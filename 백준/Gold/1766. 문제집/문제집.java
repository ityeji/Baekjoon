import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

		int n = sc.nextInt(); // 문제의 수 (정점의 수)
		int m = sc.nextInt(); // 좋은 문제에 대한 정보의 개수

		// 리스트 초기와(정점의 개수+1 만큼 인접리스트 크기 지정해주기)
		for (int i = 0; i < n + 1; i++) {
			adjList.add(new ArrayList<Integer>());
		}

		int[] indegree = new int[n + 1]; // 진입차수 배열

		for (int i = 0; i < m; i++) {
			int startIdx = sc.nextInt();
			int endIdx = sc.nextInt();

			adjList.get(startIdx).add(endIdx);
			indegree[endIdx]++; // 진입차수++
		}

		// queue에다 넣기
		PriorityQueue<Integer> queue = new PriorityQueue<>();

		// 진입차수가 0인 노드 삽입
		for (int i = 1; i < n + 1; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print(node + " ");
			for (int i : adjList.get(node)) {
				// 내 정점과 연결되어 있는 친구들
				// 진입차수를 하나씩 빼자
				indegree[i]--;
				if (indegree[i] == 0) {
					queue.offer(i);
				}
			}
		}

	}

}