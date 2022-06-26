function check(f){
	if(f.menu.value==''){
		alert("menu 를 입력해주세요");
		f.menu.focus();
		return false;
	}
	if(f.price.value==''){
		alert("가격을 입력하세요");
		f.price.focus();
		return false;
	}
	if(f.price.value < 1000 || f.price.value >=10000000){
		alert("가격은 1000원이상 천만원 이하입니다")
		f.price.value='';
		f.price.focus();
		return false;
	}
	if(f.count.value==''){
		alert("개수를 입력하세요")
		f.count.focus();
		return false;
	}
	if(f.count.value <= 0 ||f.count.value >= 1000){
		alert("수량은 1개 이상 천개 이햐여야합니다")
		f.count.value='';
		f.count.focus();
		return false;
	}
}