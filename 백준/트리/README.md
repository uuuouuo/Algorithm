# 이진 트리

</br>

## 이진 트리 객체 생성

```java
static class BiTree {
	char data;
	BiTree left, right;

	BiTree(char data) {
		this.data = data;
	}
}
```

</br>

## 이진 트리 순회 방법

### - root 위치에 따라 구분.

</br>

### 1. 전위 순회 (preorder) : root - left - right

```java
	// 전위 순회 (루트 - 좌 - 우)
	private static void preorder(BiTree root) {
		System.out.print(root.data); // root 먼저 출력.
		if(root.left != null) preorder(root.left); // 다음 좌측 출력.
		if(root.right != null) preorder(root.right); // 다음 우측 출력.
	}
```

### 2. 중위 순회 (indorder) : left - root - right

```java
	// 중위 순회 (좌 - 루트 - 우)
	private static void inorder(BiTree root) {
		if(root.left != null) inorder(root.left); // root의 좌측부터 출력.
		System.out.print(root.data); // root 출력.
		if(root.right != null) inorder(root.right); // 다음 우측 출력.

	}
```

### 3. 후위 순회 (postorder) : left - right - root

```java
	// 후위 순회 (좌 - 우 - 루트)
	private static void postorder(BiTree root) {
		if(root.left != null) postorder(root.left); // root의 좌측부터 출력.
		if(root.right != null) postorder(root.right); // 다음 우측 출력.
		System.out.print(root.data); // root 출력.
	}
```
