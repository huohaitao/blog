(function($){
	
	function isBlank(obj){
		if(obj == undefined || obj==null) return true;
		if(typeof obj == 'string') return obj.trim()==='';
		return false;
	}
	$.isBlank = isBlank;
	
})(jQuery);