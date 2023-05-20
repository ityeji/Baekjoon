import java.util.Scanner;

public class Main {

	static int n; // 노드 개수
	static Node[] arr; // Node 클래스를 원소로 가지고 있는 배열
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();

	// 클래스는 {}로 묶어줘야지!
	static class Node {
		char data;
		Node left, right;

		// 생성자로 Node 클래스 변수에 값 넣어주기
		public Node(char data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		// 이진트리이므로 Node 클래스를 만들어 주는 것이 중요!

		n = sc.nextInt();
		arr = new Node[n]; // 노드 수만큼 배열 크기 만들기

		for (int i = 0; i < n; i++) {
			arr[i] = new Node((char) (i + 'A'));
			// 0번 인덱스에 A를 루트로 가지고 있는 Node클래스
			// 1번 -> B
			// 2번 -> C
			// ...
		}

		for (int i = 0; i < n; i++) {
			char root = sc.next().charAt(0);
			char left = sc.next().charAt(0);
			char right = sc.next().charAt(0);

			// 만약, .이 입력되어있으면 노드가 존재하지 않는다는 뜻이므로
			if (left != '.') {
				// 노드가 입력되어있으면
				// root번 인덱스의 원소의 left에 left번의 Node클래스를 넣어주기
				// 노드끼리 연결해주는 것이라고 보면 된다!
				arr[root - 'A'].left = arr[left - 'A'];
			}
			if (right != '.') {
				// right도 마찬가지!
				arr[root - 'A'].right = arr[right - 'A'];
			}
		}

		// 전위순회 먼저 출력하고

		// 중위순회

		// 후위순회 순으로 출력해야하므로
		// StringBuilder에 넣어서 한 번에 출력해주자.

		preOrder(arr[0]); // A 노드부터 시작
		sb.append("\n"); // 개행도 넣어주기
		inOrder(arr[0]); // A 노드부터 시작
		sb.append("\n");
		postOrder(arr[0]); // A 노드부터 시작
		sb.append("\n");

		System.out.println(sb);

	}

	// 전위순회
	static void preOrder(Node node) {
		// arr배열의 원소는 Node 클래스이므로, 파라미터는 Node 클래스
		// root -> left -> right
		// root는 출력
		// left와 right는 재귀 부르기 (노드 따라 탐색해야하므로)
		sb.append(node.data);
		if (node.left != null) {
			preOrder(node.left);
		}
		if (node.right != null) {
			preOrder(node.right);
		}
	}

	// 중위순회
	static void inOrder(Node node) {
		// arr배열의 원소는 Node 클래스이므로, 파라미터는 Node 클래스
		// left -> root -> right
		// root는 출력
		// left와 right는 재귀 부르기 (노드 따라 탐색해야하므로)
		if (node.left != null) {
			inOrder(node.left);
		}
		sb.append(node.data);
		if (node.right != null) {
			inOrder(node.right);
		}
	}

	// 후위순회
	static void postOrder(Node node) {
		// arr배열의 원소는 Node 클래스이므로, 파라미터는 Node 클래스
		// left -> right -> root
		// root는 출력
		// left와 right는 재귀 부르기 (노드 따라 탐색해야하므로)
		if (node.left != null) {
			postOrder(node.left);
		}
		if (node.right != null) {
			postOrder(node.right);
		}
		sb.append(node.data);
	}

}