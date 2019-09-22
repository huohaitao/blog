$(function(){
	var items = $('div.item');
	var info;
	var orderq;
	
	function initQueue(){
		var queue = [];
		items.each(function(i,v){
			queue.push($(this).attr('uid'));
		});
		
		function moveTo(a, pos){
			var cpos = queue.indexOf(a);
			var beforePos = cpos > pos;
			if(beforePos){
				for(var i=cpos; i>pos; i--){
					queue[i] = queue[i-1];
				}
			}else{
				for(var i=cpos; i < pos; i++){
					queue[i] = queue[i+1];
				}
			}
			queue[pos] = a;
		}
		
		function index(e){
			return queue.indexOf(e);
		}
		
		var self = {};
		self.moveTo = moveTo;
		self.index = index;
		return self;
	}
	
	
	function dragestartListener(e){
		var tar = $(e.target);
		var id = tar.attr('uid');
		tar.addClass('drag');
		info = {tar: tar, id: id, order: orderq.index(id)};
	}
	
	function dragendListener(e){
		info.tar.removeClass('drag');
		info = null;
	}
	
	function dragenterListener(e){
		var overTar = $(e.target);
		var overId = overTar.attr('uid');
		if(overId == info.id) return;
		
		var ovorder = orderq.index(overId);
		var isUp = info.order > ovorder;
		if(isUp){
			overTar.before(info.tar);
		}else{
			overTar.after(info.tar);
		}
		info.order = ovorder;
		orderq.moveTo(info.id, ovorder);
	}
	
	function dragListener(e){
		e.preventDefault();
	}
	
	function bindDraggable(){
		items.each(function(){
			this.draggable = true;
			this.ondragstart = dragestartListener;
			this.ondragover = dragListener;
			this.ondragend = dragendListener;
			this.ondragenter = dragenterListener;
		});
	}
	
	function init(){
		orderq = initQueue();
		bindDraggable();
	}
	
	init();
});