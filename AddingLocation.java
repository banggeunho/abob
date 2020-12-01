public class locationToIndex {
	String Convert(String cur_loc, String des_loc) {
		String result="";
	if(cur_loc.startsWith("IT || IT대학 || IT융합대학 || 아융대 || 새롬관"))
		result +="0";
	if(cur_loc.startsWith("가천관 || 기술관"))
		result +="1";
	if(cur_loc.startsWith("글로벌센터 || 글센"))
		result +="2";
	if(cur_loc.startsWith("비전타워(학"))
		result +="3";
	if(cur_loc.startsWith("공과대학1 || 공대1 || 공학관"))
		result +="4";
	if(cur_loc.startsWith("비전타워(상"))
		result +="5";
	if(cur_loc.startsWith("공과대학2 || 공대2 || 창의관"))
		result +="6";
	if(cur_loc.startsWith("교육대학 || 교대"))
		result +="7";
	if(cur_loc.startsWith("중앙도서관 || 중도"))
		result +="8";
	if(cur_loc.startsWith("예술대학1 || 예대1 || 창조관"))
		result +="9";
	if(cur_loc.startsWith("전자정보도서관 || 전자정보 || 전정도"))
		result +="10";
	if(cur_loc.startsWith("예술대학2 || 예대2 || 예음관"))
		result +="11";
	if(cur_loc.startsWith("바이오나노대학 || 바나대 || 진리관"))
		result +="12";
	if(cur_loc.startsWith("바이오나노연구 || 바나연"))
		result +="13";
	if(cur_loc.startsWith("산학협력관 || 웅지관"))
		result +="14";
	if(cur_loc.startsWith("학생회관"))
		result +="15";
	if(cur_loc.startsWith("기숙사 || 긱사"))
		result +="16";
	
	if(des_loc.startsWith("IT || IT대학 || IT융합대학 || 아융대 || 새롬관"))
		result +=",0";
	if(des_loc.startsWith("가천관 || 기술관"))
		result +=",1";
	if(des_loc.startsWith("글로벌센터 || 글센"))
		result +=",2";
	if(des_loc.startsWith("비전타워(학"))
		result +=",3";
	if(des_loc.startsWith("공과대학1 || 공대1 || 공학관"))
		result +=",4";
	if(des_loc.startsWith("비전타워(상"))
		result +=",5";
	if(des_loc.startsWith("공과대학2 || 공대2 || 창의관"))
		result +=",6";
	if(des_loc.startsWith("교육대학 || 교대"))
		result +=",7";
	if(des_loc.startsWith("중앙도서관 || 중도"))
		result +=",8";
	if(des_loc.startsWith("예술대학1 || 예대1 || 창조관"))
		result +=",9";
	if(des_loc.startsWith("전자정보도서관 || 전자정보 || 전정도"))
		result +=",10";
	if(des_loc.startsWith("예술대학2 || 예대2 || 예음관"))
		result +=",11";
	if(des_loc.startsWith("바이오나노대학 || 바나대 || 진리관"))
		result +=",12";
	if(des_loc.startsWith("바이오나노연구 || 바나연"))
		result +=",13";
	if(des_loc.startsWith("산학협력관 || 웅지관"))
		result +=",14";
	if(des_loc.startsWith("학생회관"))
		result +=",15";
	if(des_loc.startsWith("기숙사 || 긱사"))
		result +=",16";
	
	return result; 
	}
}