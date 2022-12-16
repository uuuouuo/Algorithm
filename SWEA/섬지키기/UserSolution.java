package 섬지키기;

class UserSolution {
	
	/**
	 * 접근 방법
     1. 맵을 전처리
     	-> 맨앞 수 빼고, 4를 더함 그리고 하나의 숫자로 처리 -> 패턴 찾기
     	-> 주의점: 팰린드롬 (앞뒤로 바꿔도 같은 경우) map[x]/2로 
     		- 1. 각 자리 숫자를 배열에 넣어서 좌우 대칭인지 확인 
     			 시간 복잡도 : 길이만큼
     		- 2. 정수를 뒤집은 값이랑 비교
     			 121 == 121 인 경우 땡
	 */
	public void init(int N, int mMap[][]) { // N: 섬 길이 mMap: 섬 고도 나타냄
	}

	// 구조물 높이 올라감
	// 올라간 후엔 M개의 섬의 고도 일치해야함
	// 회전 가능
	public int numberOfCandidate(int M, int mStructure[]) { // M: 구조물 길이
		return 0;
	}

	/** 접근방법
	 1. Flood Fill
	 */
	// mSeaLevel-1 이하 지역 침투
	// 상하좌우 육지 침투
	public int maxArea(int M, int mStructure[], int mSeaLevel) {
		return 0;
	}
}
