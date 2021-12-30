# 이분 탐색

- 배열 정렬 필요
- 시간 복잡도: O(logN)
- 메커니즘

  1. 중간 인텍스 찾기
  2. 중간 인덱스와 key 값 비교
  3. 중간 값보다 작다면 좌측, 크다면 우측 탐색, 같다면 반환 후 종료

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
