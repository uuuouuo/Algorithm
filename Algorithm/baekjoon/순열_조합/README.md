# 순열

```java

```

# 조합

```java
static int input[], result[];
	private static void comb(int start, int idx) {
		if(idx == R) {
			// 문제에 따른 코드 구현
			return;
		}

		for (int i = start; i < N; i++) {
			result[idx] = arr[i];
			comb(i + 1, idx + 1);
		}

	}
```
