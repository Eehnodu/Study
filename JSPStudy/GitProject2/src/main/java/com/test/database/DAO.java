package com.test.database;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.test.model.AccChangeVO;
import com.test.model.AccExerciseVO;
import com.test.model.CalendarEventVO;
import com.test.model.ExerciseVO;
import com.test.model.FitnessCenterVO;
import com.test.model.MemberVO;
import com.test.model.MonthImgVO;
import com.test.model.PersonalTrainingVO;
import com.test.model.PurchaseVO;
import com.test.model.ReserveVO;
import com.test.model.SaltVO;
import com.test.model.SentenceVO;
import com.test.model.StdDataVO;
import com.test.model.TrainerVO;
import com.test.model.VoucherVO;

public class DAO {

	private SqlSessionFactory factory = MySqlSessionManager.getSqlSessionFactory();

	// 회원가입 시 id에 해당하는 salt값 저장
	public int saltJoin(SaltVO vo) {
		SqlSession session = factory.openSession(true);
		int row = session.insert("salt_join", vo);
		session.close();
		return row;
	}

	// 로그인 시 id에 해당하는 salt값 가져오기
	public SaltVO saltLogin(SaltVO vo) {
		SqlSession session = factory.openSession();
		SaltVO result = session.selectOne("salt_login", vo);
		session.close();
		return result;
	}

	// 회원가입
	public int join(MemberVO vo) {
		// insert, update, delete 수행시 true를 적어서 auto commit 되게 할 것!
		SqlSession session = factory.openSession(true);
		int row = session.insert("mem_join", vo);
		session.close();
		return row;
	}

	// 로그인
	public MemberVO login(MemberVO vo) {
		SqlSession session = factory.openSession();
		MemberVO result = session.selectOne("mem_login", vo);
		session.close();
		return result;
	}

	// 개인정보수정
	public void updateMem(MemberVO vo) {
		SqlSession session = factory.openSession(true);
		session.update("mem_update", vo);
		session.close();
	}

	// salt값 수정
	public void updateSalt(SaltVO vo) {
		SqlSession session = factory.openSession(true);
		session.update("salt_update", vo);
		session.close();
	}

	// 회원 탈퇴
	public void unregister(MemberVO vo) {
		SqlSession session = factory.openSession(true);
		session.delete("mem_unregister", vo);
		session.close();
	}

	// 누적 운동 입력
	public int accExInput(AccExerciseVO vo) {
		SqlSession session = factory.openSession(true);
		int row = session.insert("acc_ex_input", vo);
		session.close();
		return row;
	}

	// tb_exercise에서 운동명에 해당하는 ex_idx값 가져오기
	public ExerciseVO getExidx(ExerciseVO vo) {
		SqlSession session = factory.openSession();
		ExerciseVO result = session.selectOne("get_ex_idx", vo);
		session.close();
		return result;
	}

	// 누적 운동에서 ex_date와 ex_calories 가져오기
	public ArrayList<AccExerciseVO> getAcExData(String mem_id) {
		SqlSession session = factory.openSession();
		ArrayList<AccExerciseVO> list = new ArrayList<>(session.selectList("get_acex_data", mem_id));
		session.close();
		return list;
	}

	// mem_id에 해당하는 height 값 가져오기
	public MemberVO getHeight(String mem_id) {
		SqlSession session = factory.openSession();
		MemberVO result = session.selectOne("get_mem_height", mem_id);
		session.close();
		return result;
	}

	// 누적 신체변화량 입력
	public int accChInput(AccChangeVO vo) {
		SqlSession session = factory.openSession(true);
		int row = session.insert("acc_ch_input", vo);
		session.close();
		return row;
	}

	// 운동의 카테고리 가져오기
	public ArrayList<AccExerciseVO> getAcExCate(AccExerciseVO vo) {
		SqlSession session = factory.openSession();
		ArrayList<AccExerciseVO> list = new ArrayList<>(session.selectList("get_acex_date", vo));
		session.close();
		return list;
	}

	// DAO.java 파일에 추가
	// mem_id와 시작일부터 종료일까지의 신체 변화 데이터 가져오기
	public ArrayList<AccChangeVO> getAccChangeData(AccChangeVO vo) {
		SqlSession session = factory.openSession();
		ArrayList<AccChangeVO> list = new ArrayList<>(session.selectList("get_acch_date", vo));
		session.close();
		return list;
	}

	// 오늘 날짜의 해당월의 1일부터 오늘날짜까지의 값 가져오기
	public ArrayList<AccChangeVO> getCountDate(AccChangeVO vo) {
		SqlSession session = factory.openSession();
		ArrayList<AccChangeVO> list = new ArrayList<>(session.selectList("get_count_date", vo));
		session.close();
		return list;
	}

	// 비교페이지에 들어갈 유저의 최신 데이터 가져오기
	public MemberVO MemPhysicalData(String mem_id) {
		SqlSession session = factory.openSession();
		MemberVO result = session.selectOne("get_mem_data", mem_id);
		session.close();
		return result;
	}

	// 비교페이지에 들어갈 표준데이터 가져오기
	public StdDataVO StdPhysicalData(StdDataVO vo) {
		SqlSession session = factory.openSession();
		StdDataVO result = session.selectOne("get_std_data", vo);
		session.close();
		return result;
	}

	// 네이버 회원가입 시 이메일가져오기
	public MemberVO getMemberByEmail(String email) {
		SqlSession session = factory.openSession();
		MemberVO result = session.selectOne("get_member_by_email", email);
		session.close();
		return result;
	}

	// 캘린더 이벤트를 저장하는 메서드
	public int saveCalendarEvent(CalendarEventVO eventVO) {
		SqlSession session = factory.openSession(true);
		int row = session.insert("insertCalendarEvent", eventVO);
		session.close();
		return row;
	}

	// 캘린더에 저장된 값을 가져오는 메서드
	public ArrayList<CalendarEventVO> fetchCalendarEvent(String mem_id) {
		SqlSession session = factory.openSession();
		ArrayList<CalendarEventVO> list = new ArrayList<>(session.selectList("fetchCalendarEvent", mem_id));
		session.close();
		return list;
	}

	// 캘린더에 저장된 값을 수정하는 메서드
	public void updateCalendarEvent(CalendarEventVO vo) {
		SqlSession session = factory.openSession(true);
		session.update("updateCalendarEvent", vo);
		session.close();
	}

	// 캘린더에 저장된 값을 삭제하는 메서드
	public void deleteCalendarEvent(int calIdx) {
		SqlSession session = factory.openSession(true);
		session.delete("deleteCalendarEvent", calIdx);
		session.close();
	}

	// 문구 가져오기
	public SentenceVO getSentence(int idx) {
		SqlSession session = factory.openSession();
		SentenceVO result = session.selectOne("get_sentence_data", idx);
		session.close();
		return result;
	}

	// 해당월의 이미자와 문구 가져오기
	public MonthImgVO getMonthImgSen(int month) {
		SqlSession session = factory.openSession();
		MonthImgVO result = session.selectOne("get_month_img", month);
		session.close();
		return result;
	}
	
	// 트레이너 입력하면 트레이너 정보 가져오기
	public TrainerVO selectTrainer(String trn_name) {
	    SqlSession session = factory.openSession();
	    TrainerVO result =  session.selectOne("selectTrainer",trn_name);
	    session.close();
	    return result;
	}
	
	//  트레이너 이름에 해당하는 피트니스센터가져오기
	public FitnessCenterVO fit_center(String trn_name) {
        SqlSession session = factory.openSession();
        FitnessCenterVO result =session.selectOne("fit_center", trn_name);
        return result;
        }
	// 사용권 정보 불러오기
	public ArrayList<VoucherVO> voucher(String trn_name) {
        SqlSession session = factory.openSession();
        ArrayList<VoucherVO> list =new ArrayList<>(session.selectList("voucher", trn_name));
        return list;
        }
	// 트레이너들 불러오기
	public ArrayList<TrainerVO> select_trn_list(){
		SqlSession session = factory.openSession();
		ArrayList<TrainerVO> list = new ArrayList<>(session.selectList("select_trn_list"));
		return list;
	}
	
	// DAO 클래스의 insert_Purchase 메서드
	public int insert_Purchase(PurchaseVO vo) {
	    SqlSession session = factory.openSession(true);
	    int row = session.insert("insert_Purchase", vo); 
	    session.close();
	    return row;
	}

	public ArrayList<PersonalTrainingVO> PT(int trn_idx) {
		SqlSession session = factory.openSession();
        ArrayList<PersonalTrainingVO> list =new ArrayList<>(session.selectList("PT", trn_idx));
        return list;
		
	}

	public int RsvCommit(String mem_id, int pt_idx, String created_at, String res_status) {
	    SqlSession session = factory.openSession(true);
	    ReserveVO vo = new ReserveVO(mem_id,pt_idx, created_at, res_status);
	    int row = session.insert("RsvCommit", vo); // 예약 정보 DB에 저장
	    session.close();
	    return row;
	}

}
