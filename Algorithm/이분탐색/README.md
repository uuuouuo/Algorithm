# 이분 탐색

- 배열 정렬 필요
- 시간 복잡도: O(logN)
- 메커니즘

  1. 중간 인텍스 찾기
  2. 중간 인덱스와 key 값 비교
  3. 중간 값보다 작다면 좌측, 크다면 우측 탐색, 같다면 반환 후 종료

- 접근 방법

  1.  탐색 범위 정하기 : 거리 2. 구하려는 대상(최대, 최소)의 범위 변경하며 확인 : 집간 거리 3. 조건에 맞는 지 확인

  </br>

  ```java
      // 재귀적 탐색
  private static void binarySearch1(int low, int high, int key) {
  	int mid = (low + high) / 2;

  	if (low <= high) {
  		if (A[mid] == key) {
  			System.out.println(1);
  			return;
  		}

  		else if (A[mid] > key) {
  			binarySearch1(low, mid - 1, key);
  		}

  		else {
  			binarySearch1(mid + 1, high, key);
  		}
  	}

  	else System.out.println(0); // 재귀는 너무 어려워;
  	return; // 재귀로 인해 마지막은 다시 처음으로 돌아옴.

  }

  	// 반복적 탐색
  private static void binarySearch2(int key) {

  	int low = 0, high = N - 1;
  	int mid;

  	// low가 high보다 커지기 전까지 반복
  	while(low <= high) {
  		mid = (low + high) / 2;

  		if(A[mid] > key) {
  			high = mid - 1;
  		}

  		else if(A[mid] < key) {
  			low = mid + 1;
  		}

  		else {
  			System.out.println(1);
  			return;
  		}
  	}

  	System.out.println(0);
  	return;

  }
  ```

  </br>

## 파라메트릭 서치

- 특정 값을 구하라는 문제(최대 값, 최소 값을 구하라)를 결정 문제로 바꿔서 생각하는 방법
- 시간 복잡도 : O(MlogN)
- 주어진 범위 내에서 원하는 값 or 조건에 일치하는 값을 찾아내는 알고리즘
- 이진 탐색과 약간 개념 차이가 있을 뿐 구현은 유사
- 꼭 정렬하지 않아도 됨
