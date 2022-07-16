import java.util.*;

public class UserSolution {
	
	static HashMap<Integer, HashMap<Character, List<Student>>> search; // 학년별, 성별
	static HashMap<Integer, Student> students; // 전체
	static class Student implements Comparable<Student>{
		int mId, mGrade, mScore;
		char mGender; // m: male, f: female
		public Student(int mId, int mGrade, char mGender, int mScore) {
			this.mId = mId;
			this.mGrade = mGrade;
			this.mGender = mGender;
			this.mScore = mScore;
		}
		
		@Override
	    public int compareTo(Student s) {
	      if (this.mScore == s.mScore) {
	        return this.mId - s.mId;
	      }
	      return this.mScore - s.mScore;
	    }
	}
	
	public void init() {
		students = new HashMap<>();
		search = new HashMap<>();
		for(int i = 1; i < 4; i++) {
			HashMap<Character, List<Student>> map = new HashMap<>();
			map.put('m', new ArrayList<>());
			map.put('f', new ArrayList<>());
			search.put(i, map);			
		}
		return;
	}

	public int add(int mId, int mGrade, char mGender[], int mScore) {
		char gender = mGender[0];
		Student std = new Student(mId, mGrade, gender, mScore);
		students.put(mId, std); // 전체에 추가
		
		// 검색용에 추가
		HashMap<Character, List<Student>> map = search.get(mGrade);
		List<Student> list = map.get(gender); // 같은 학년,성별 리스트 가져오기
		list.add(std); // 해당 리스트에 학생 넣기					
		map.put(gender, list); // 갱신
		search.put(mGrade, map); // 갱신

		return Collections.max(list).mId;
	}

	public int remove(int mId) {
		if(!students.containsKey(mId)) return 0;
		
		Student std = students.get(mId);
		int grade = std.mGrade;
		char gender = std.mGender;
		
		students.remove(mId); // 전체에서 삭제
		
		List<Student> list = search.get(grade).get(gender);
		list.removeIf(s -> s.mId == mId); // 같은 학년/성별 리스트에서 삭제
		
		if(list.size() == 0) return 0;
		return Collections.min(list).mId;
	}

	public int query(int mGradeCnt, int mGrade[], int mGenderCnt, char mGender[][], int mScore) {
		List<Student> result= new ArrayList<>(6);
				
        for (int i = 0; i < mGradeCnt && mGrade[i]!=0; i++) {
			for (int j = 0; j < mGenderCnt; j++) {
				int grade = mGrade[i];
				char g = mGender[j][0];
				if(g == '\0') break;
				
				// null일 경우도 있으니까 Optional
				Optional<Student> std = search.get(grade).get(g).stream()
						.filter(s -> s.mScore >= mScore).min((s1, s2) -> {		
							if(s1.mScore == s2.mScore)
								return s1.mId - s2.mId;
							return s1.mScore - s2.mScore;
						}); // 가장 작은 값 찾기
				
				if(std.isPresent()) result.add(std.get());
			}
		}
		if(result.size() == 0) return 0;
		return Collections.min(result).mId;
	}
}
