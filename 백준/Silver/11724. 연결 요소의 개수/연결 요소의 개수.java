import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	// BFS로 풀자
	// BFS가 한 번 끝나면 count++해주는 걸로!

	static Queue<Integer> queue = new LinkedList<>();

	static boolean[] visited; // 박문철2

	static int n;
	static List<ArrayList<Integer>> adjList = new ArrayList<>(); // 인접 리스트

	public static void BFS(int node) {
		// 시작 정점 큐에 넣기
		queue.offer(node);
		// 방문처리
		visited[node] = true;

		// 큐가 공백이 될 때까지 반복문 수행
		// 큐가 공백이 아니라면, 반복문 미수행
		while (!queue.isEmpty()) {
			// 정점에서 하나 꺼내
			int curr = queue.poll();

			int size = adjList.get(curr).size();

			// 꺼낸 것이 연결되어있고, 박문철2 되어있지 않으면
			// 큐에 넣기
			// for문 돌면서 curr와 연결되어있는지 하나하나 찾아봐야함.
			for (int i = 0; i < size; i++) { // 아!!!! 한 정점에 연결되어있는 정점이 여러개일 수 있으니!!!
				// 밑 줄에서 get(0)을 하면 안되지!!! -> 이렇게 되면 연결되어있는 정점이 하나라는 소리니까!
				int adjNum = adjList.get(curr).get(i);
				if (!visited[adjNum]) {
					queue.offer(adjNum);
					// 박문철2도 해줘야함
					visited[adjNum] = true;
				}
			}
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		visited = new boolean[n + 1];

		// 정점 수만큼 adjList 방을 만들고, 각 방마다 ArrayList 할당해주기
		for (int i = 0; i < n + 1; i++) {
			adjList.add(new ArrayList<>());
		}

		int m = sc.nextInt();

		for (int i = 0; i < m; i++) {
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();

			// 무방향 연결시키기
			// node1방에 node2 입력하기 (연결되어있어! 알려주기)
			adjList.get(node1).add(node2);
			adjList.get(node2).add(node1);
		}

		int count = 0;

		for (int i = 1; i < n + 1; i++) {
			if (!visited[i]) {
				BFS(i);
				count++;
			}

		}

		System.out.println(count);

	}

}