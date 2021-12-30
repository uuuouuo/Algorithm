package 트리;

import java.util.Scanner;

/** 트리 순회 - 정확히 이해 안돼 */
public class bj1991 {

	static int N;
	static BiTree Root;

	// 이진 트리 객체.
	static class BiTree {
		char data;
		BiTree left, right;

		BiTree(char data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			char data = sc.next().charAt(0); // String -> char
			char left = sc.next().charAt(0);
			char right = sc.next().charAt(0);

			createNode(data, left, right);
		}

		preorder(Root);
		System.out.println();
		inorder(Root);
		System.out.println();
		postorder(Root);
		System.out.println();

	}

	// 노드 정보 받을 때 생성.
	private static void createNode(char data, char left, char right) {

		if (Root == null) { // root 초기상태.
			Root = new BiTree(data);

			if (left != '.') { // 좌측 자식 노드 생성.
				Root.left = new BiTree(left);
			}

			if (right != '.') { // 우측 자식 노드 생성.
				Root.right = new BiTree(right);
			}

		} else { // root 초기상태 아니면, 위치 찾아야함.
			searchNode(Root, data, left, right);
		}

	}

	private static void searchNode(BiTree root, char data, char left, char right) {
		if (root == null)
			return; // 해당 노드 null 일 경우 return.

		else if (root.data == data) { // 위치 찾은 경우.
			if (left != '.') {
				root.left = new BiTree(left);
			}
			if (right != '.') {
				root.right = new BiTree(right);
			}
		} else { // 더 탐색이 필요한 경우.
			// 해당 노드의 자식 확인.
			searchNode(root.left, data, left, right);
			searchNode(root.right, data, left, right);
		}
	}

	// 전위 순회 (루트 - 좌 - 우)
	private static void preorder(BiTree root) {
		System.out.print(root.data); // root 먼저 출력.
		if (root.left != null)
			preorder(root.left); // 다음 좌측 출력.
		if (root.right != null)
			preorder(root.right); // 다음 우측 출력.
	}

	// 중위 순회 (좌 - 루트 - 우)
	private static void inorder(BiTree root) {
		if (root.left != null)
			inorder(root.left); // root의 좌측부터 출력.
		System.out.print(root.data); // root 출력.
		if (root.right != null)
			inorder(root.right); // 다음 우측 출력.

	}

	// 후위 순회 (좌 - 우 - 루트)
	private static void postorder(BiTree root) {
		if (root.left != null)
			postorder(root.left); // root의 좌측부터 출력.
		if (root.right != null)
			postorder(root.right); // 다음 우측 출력.
		System.out.print(root.data); // root 출력.
	}

}
