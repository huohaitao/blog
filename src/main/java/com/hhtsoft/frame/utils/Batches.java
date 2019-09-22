/**
 * 
 */
package com.hhtsoft.frame.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hhtsoft.frame.function.ExConsumer;
import com.hhtsoft.frame.function.ExFunction;

/**
 * @author huoht
 *
 */
public class Batches {

	private static Logger logger = LoggerFactory.getLogger(Batches.class);
	
	public static <T,R> List<R> execute(int batchSize, Collection<T> data, ExFunction<List<T>, List<R>> action) {
		if(batchSize < 1 || data.isEmpty()) return new ArrayList<>(1);
		List<T> copy = new ArrayList<>(data);
		List<T> batch = new ArrayList<>(batchSize);
		List<R> rs = new ArrayList<>();
		int startIndex = 0;
		int batchTime = 0;
		long startTime = System.currentTimeMillis();
		String acname = Strings.join("batch-execution-", startTime);
		logger.debug("Start [{}]", acname);
		while(true) {
			int endIndex = startIndex + batchSize;
			boolean isLastBatch = endIndex >= copy.size();
			endIndex = isLastBatch ? copy.size() : endIndex;
			batchTime += 1;
			long batchStart = System.currentTimeMillis();
			batch.addAll(copy.subList(startIndex, endIndex));
			List<R> r = action.execute(batch);
			rs.addAll(r);
			logger.debug("[{}] compelete batch-{}, time:{}ms", acname, batchTime, (System.currentTimeMillis()-batchStart));
			if(isLastBatch) break;
			batch.clear();
			startIndex = endIndex;
		}
		logger.debug("Compelete [{}], time:{}ms", acname, (System.currentTimeMillis()-startTime));
		return rs;
	}
	
	public static <T> void consume(int batchSize, Collection<T> data, ExConsumer<List<T>> action) {
		if(batchSize < 1 || data.isEmpty()) return;
		List<T> copy = new ArrayList<>(data);
		List<T> batch = new ArrayList<>(batchSize);
		int startIndex = 0;
		int batchTime = 0;
		long startTime = System.currentTimeMillis();
		String acname = Strings.join("batch-execution-", startTime);
		logger.debug("Start [{}]", acname);
		while(true) {
			int endIndex = startIndex + batchSize;
			boolean isLastBatch = endIndex >= copy.size();
			endIndex = isLastBatch ? copy.size() : endIndex;
			batchTime += 1;
			long batchStart = System.currentTimeMillis();
			batch.addAll(copy.subList(startIndex, endIndex));
			action.consume(batch);
			logger.debug("[{}] compelete batch-{}, time:{}ms", acname, batchTime, (System.currentTimeMillis()-batchStart));
			if(isLastBatch) break;
			batch.clear();
			startIndex = endIndex;
		}
		logger.debug("Compelete [{}], time:{}ms", acname, (System.currentTimeMillis()-startTime));
	}
}
