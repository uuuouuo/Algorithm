package 메모리시스템;

import java.util.*;

class UserSolution {
	
	static int total;
	static TreeSet<Memory> empty; // 메모리의 빈공간 저장하고 할당할 곳 찾기
	static TreeMap<Integer, Integer> alloc; // 인덱스, 사이즈
	public void init(int N) {
		total = N;
		alloc = new TreeMap<>();
		empty = new TreeSet<>();
		empty.add(new Memory(0, N)); // 처음 빈공간 전체크기의 0인덱스 저장
		
		return;
	}

	/** 자료 구조 정하기
	 * 1. 빈공간 넣기
	 * 2. 최소 빈공간 찾기
	 * 3. 사용한 빈공간 삭제
	 	-> 만약 빈공간보다 사이즈가 작으면 남은 빈공간 저장
	 */
	public int allocate(int mSize) {
		if(empty.size() == 0) return -1; // 할당할 메모리 없으면 
		
		Memory result = null;
		for(Memory m : empty) {
			if(m.size < mSize) continue; // mSize보다 작으면 패스
			
			result = m;
			alloc.put(result.idx, mSize); // 할당 메모리 저장
			empty.remove(m); // 메모리 사용하면 삭제
			
			if(m.size > mSize) // 해당 메모리가 mSize보다 크면 남은 메모리 저장
				empty.add(new Memory(m.idx + mSize, m.size - mSize)); 
			break;
		}
		
		if(result == null) return -1; // 메모리 공간 찾지 못했으면
		
//		System.out.println("--- empty memory ---");
//		for(Memory m : empty)
//			System.out.println(m.idx + " " + m.size);
//		System.out.println("--- allocation memory ---");
//		alloc.forEach((k, v) -> System.out.println(k+" "+v));
		
		return result.idx;
	}

	/** 접근방법
	 1. 해당 인덱스 공간 찾고 삭제
	 	-> 찾을 때 get 이용
	 	-> 인덱스 오름차순 저장 (TreeMap 사용)
	 2. 앞뒤에 공간도 빈공간이라면 합치기 
	 	-> 앞뒤 빈공간 삭제 & 합치기
	 */
	public int release(int mAddr) {
		if(alloc.size() == 0 || alloc.get(mAddr) == null) return -1;
		
		int idx = mAddr;
		int size = alloc.get(mAddr); // 사이즈 가져오기
		int result = size;
		
		alloc.remove(mAddr); // 메모리 해제
		
		List<Memory> list = new ArrayList<>(); // 삭제할 공간 담기
		for(Memory m : empty) {
			
			// mAddr = 6 이고,
			// [0][1][2][3][4][5] -> m.idx = 0, m.size = 6 이면
			if(mAddr == m.idx + m.size) { // 이전 메모리가 빈공간이면
				idx = m.idx; // 이전 인덱스로 바꿈
				size += m.size; // 크기 추가
				list.add(m);
			}
			// mAddr = 6, result(사이즈) = 4,
			// [10][11][12][13][14][15] -> m.idx = 10, m.size = 6 이면
			if(m.idx == mAddr + result) { // 다음 메모리가 빈공간이면
				size += m.size; // 크기추가
				list.add(m);
			}
		}
		
		for(Memory m : list)
			empty.remove(m);

		empty.add(new Memory(idx, size)); // 빈공간 추가
		
//		System.out.println("--- empty memory ---");
//		for(Memory m : empty)
//			System.out.println(m.idx + " " + m.size);
//		System.out.println("--- allocation memory ---");
//		alloc.forEach((k, v) -> System.out.println(k+" "+v));
		
		return result;
	}
	
	static class Memory implements Comparable<Memory>{
		int idx, size;
		
		public Memory(int idx, int size) {
			this.idx = idx;
			this.size = size;
		}
		
		// 가장 작은 빈공간에 할당 (같은 사이즈인 경우 인덱스가 작은 곳)
		public int compareTo(Memory m) {
			if(this.size == m.size) // 크기 같다면 인덱스 오름차순
				return this.idx - m.idx;
			return this.size - m.size; // 크기 오름차순
		}
	}

}