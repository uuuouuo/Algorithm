# 순열

```java
static int N, R, input[], result[];
static boolean visited[];
	private static void perm(int start, int idx) {
		if(idx == R) {
			// 문제에 따른 코드 구현
			return;
		}

		for (int i = start; i < N; i++) {

			if(visited[i]){
				result[idx] = input[i];
				visited[i] = true;
				perm(i + 1, idx + 1);
				visited[i] = false;
			}

		}

	}
```

# 조합

```java
static int N, R, input[], result[];
	private static void comb(int start, int idx) {
		if(idx == R) {
			// 문제에 따른 코드 구현
			return;
		}

		for (int i = start; i < N; i++) {
			result[idx] = input[i];
			comb(i + 1, idx + 1);
		}

	}
```

# 부분 집합

```java
static int input[];
static boolean selected[];
	private static void subset(int idx) {
		if(idx == N) {
			// 문제에 따른 코드 구현
			return;
		}

			selected[idx] = true;
			subset(idx + 1);
			selected[idx] = false;
			subset(idx + 1);

	}
```
