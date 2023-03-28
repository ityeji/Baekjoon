import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	static int n; // 정점의 개수

	static int m; // 간선의 개수

	static int v; // 시작 정점의 개수

	static int[][] graph; // 그래프 저장

	static boolean[] visited; // 방문 여부 저장

	static Queue<Integer> queue = new LinkedList<>();

	public static void input() {

		n = sc.nextInt();

		m = sc.nextInt();

		v = sc.nextInt();

		graph = new int[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			int idx1 = sc.nextInt();
			int idx2 = sc.nextInt();

			// 무향이니 서로를 바꿔준
			graph[idx1][idx2] = 1; // 연결되어있다를 1로 표현!
			graph[idx2][idx1] = 1;

		}

		visited = new boolean[n + 1];

		DFS(v);

		System.out.println();

		visited = new boolean[n + 1];

		BFS(v);
	}

	public static void DFS(int i) { // DFS는 재귀 + for문

		System.out.print(i + " "); // 일단 방문 노드 출력

		visited[i] = true; // 나 i 방문햇어!

		// 전체 노드 돌면서 나랑 연결된 노드 찾아 방문(여기서 방문은 재귀로 해당 함수를 부르는 것을 뜻함)
		for (int idx = 1; idx < n + 1; idx++) {
			// 여기서, 방문했던 곳은 빼줘야함.
			if (graph[i][idx] == 1 && !visited[idx]) {
				DFS(idx);
			}
		}
	}

	public static void BFS(int i) { // BFS는 큐

		// 큐에 방문된 노드를 삽입한다.
		queue.offer(i);

		while (!queue.isEmpty()) { // 큐가 비어있지 않으면
			int node = queue.poll(); // 큐에서 해당 원소 꺼내기

			System.out.print(node + " ");
			// 방문 처리하기
			visited[node] = true;

			// 인접한 정점들을 큐에 추가하기
			// 노드와 이어져있고, 방문 이력이 없는 것을 큐에 넣어주기
			// 이때, 큐에 넣어주면서 또 방문처리를 해야하는데,
			// 나중에 인접한 노드가 중복이 될 때, 아직 방문을 하진 않았으므로 방문 처리 여부가 false로 되어있어
			// 큐에 또 넣을 가능성이 있기 때문

			for (int idx = 1; idx < n + 1; idx++) {
				if (graph[node][idx] == 1 && !visited[idx]) {
					queue.offer(idx); // 해당 노드를 큐에 넣고
					visited[idx] = true; // 방문한 것으로 표시함.
				}
			}

		}
	}

	public static void main(String[] args) {

		input();

	}

}