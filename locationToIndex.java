
/*Index 별 장소 지정(column)
 * 0: IT대학
 * 1: 가천관(식당)
 * 2: 글로벌센터
 * 3: 비전타워(학식)
 * 4: 공과대학1
 * 5: 비전타워(식당가)
 * 6: 공과대학2
 * 7: 교육대학원(학식)
 * 8: 중앙도서관
 * 9: 예술대학1(학식)
 * 10: 전자정보도서관
 * 11: 예술대학2
 * 12: 바이오나노대학
 * 13: 바이오나노연구원
 * 14: 웅지관
 * 15: 학생회관
 * 16: 기숙사
 */   // 식당 있는 곳 1, 3, 5, 7, 9

public class locationToIndex {
	String Convert(String cur_loc, String des_loc) {
		String result="";
	if(cur_loc.startsWith("IT"))
		result +="0";
	if(cur_loc.startsWith("가천관"))
		result +="1";
	if(cur_loc.startsWith("글로벌센터"))
		result +="2";
	if(cur_loc.startsWith("비전타워(학"))
		result +="3";
	if(cur_loc.startsWith("공과대학1"))
		result +="4";
	if(cur_loc.startsWith("비전타워(상"))
		result +="5";
	if(cur_loc.startsWith("공과대학2"))
		result +="6";
	if(cur_loc.startsWith("교육대학"))
		result +="7";
	if(cur_loc.startsWith("중앙도서관"))
		result +="8";
	if(cur_loc.startsWith("예술대학1"))
		result +="9";
	if(cur_loc.startsWith("전자정보"))
		result +="10";
	if(cur_loc.startsWith("예술대학2"))
		result +="11";
	if(cur_loc.startsWith("바이오나노대학"))
		result +="12";
	if(cur_loc.startsWith("바이오나노연구"))
		result +="13";
	if(cur_loc.startsWith("웅지"))
		result +="14";
	if(cur_loc.startsWith("학생회"))
		result +="15";
	if(cur_loc.startsWith("기숙사"))
		result +="16";
	
	if(des_loc.startsWith("IT"))
		result +=",0";
	if(des_loc.startsWith("가천관"))
		result +=",1";
	if(des_loc.startsWith("글로벌센터"))
		result +=",2";
	if(des_loc.startsWith("비전타워(학"))
		result +=",3";
	if(des_loc.startsWith("공과대학1"))
		result +=",4";
	if(des_loc.startsWith("비전타워(상"))
		result +=",5";
	if(des_loc.startsWith("공과대학2"))
		result +=",6";
	if(des_loc.startsWith("교육대학"))
		result +=",7";
	if(des_loc.startsWith("중앙도서관"))
		result +=",8";
	if(des_loc.startsWith("예술대학1"))
		result +=",9";
	if(des_loc.startsWith("전자정보"))
		result +=",10";
	if(des_loc.startsWith("예술대학2"))
		result +=",11";
	if(des_loc.startsWith("바이오나노대학"))
		result +=",12";
	if(des_loc.startsWith("바이오나노연구"))
		result +=",13";
	if(des_loc.startsWith("웅지"))
		result +=",14";
	if(des_loc.startsWith("학생회"))
		result +=",15";
	if(des_loc.startsWith("기숙사"))
		result +=",16";
	
	return result; 
	}
}
