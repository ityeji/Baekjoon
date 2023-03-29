import java.util.Scanner;

public class Main {

	// DFS로 탐색하자

	static Scanner sc = new Scanner(System.in);

	static int[][] net; // 네트워크

	static int count;

	static boolean[] visited; // 방문체크

	static int num; // 컴퓨터의 수

	public static void input() {

		num = sc.nextInt(); // 컴퓨터의 수

		int connectCom = sc.nextInt(); // 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수

		net = new int[num + 1][num + 1]; // 인덱스에 간선 표시해주자 (1)

		visited = new boolean[num + 1];

		count = 0;

		for (int i = 0; i < connectCom; i++) {
			int x = sc.nextInt();

			int y = sc.nextInt();

			net[x][y] = 1;
			net[y][x] = 1;
		}

		DFS(1);
	}

	public static void DFS(int node) { // 해당 node를 방문합니다!

		visited[node] = true;

		// 그럼 방문한 노드와 연결되어있는 node는 뭐가있지?
		for (int i = 1; i < num + 1; i++) {
			if (!visited[i] && net[node][i] == 1) {
				count++;
				DFS(i);
			}
		}

	}

	public static void main(String[] args) {

		input();

		System.out.println(count);
	}

}