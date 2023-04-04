
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	// 꼭 한 학생이 한 학생 앞에 서야하는 순서가 정해진 문제이므로
	// 위상정렬을 써야한다.
	// 사이클이 없는 방향 그래프
	// 먼저 처리할 일들 처리하고, 나중일 처리하기

	static int[] indegree; // 진입차수 저장할 배열

//    static int[][] adjArr; // 인접행렬
	// 인접행렬은 메모리 터짐
	// 그래프의 연결관계를 이차원 배열로 나타내는 방식

	// 인접 리스트를 사용해야한다.
	// 리스트 안에 리스트 넣어놓고
	// start 번호를 인덱스로 가지고 있는 저장 위치에 end 값을 원소로 넣는다
//     왜 List안에 List?
	// 한 정점에서 여러 갈래가 뻗칠 수 있으므로
	// 해당 인덱스의 저장 공간을 list로 주어 뻗어지는 end정점들을 저장하려고
	static ArrayList<ArrayList<Integer>> adjList;

	static Queue<Integer> q;

	static StringBuilder sb; // 빠른 속도를 위해

	// 위상 정렬
	// 먼저 진입차수가 0인 정점들을 큐에 넣기
	// 큐가 빌 때까지
	// 큐의 원소 하나 빼서
	// 연결된 정점 찾아서
	// 그 연결된 정점을 인덱스로 가지고 있는 진입차수 하나 빼주고 출력
	// 만약, 진입차수가 0이 되면? -> 큐에 넣어주기

	public static void topologicalSorting(int n) {

		for (int i = 1; i < n + 1; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int node = q.poll();

			sb.append(node + " ");

			for (int i = 0; i < adjList.get(node).size(); i++) {
				indegree[adjList.get(node).get(i)]--; // adjList.get(node).get(i)는 node(시작정점)과 연결되어있는 end정점들을 반환

				if (indegree[adjList.get(node).get(i)] == 0) {
					q.offer(adjList.get(node).get(i));
				}
			}

		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 학생의 번호는 1~n번
		int m = sc.nextInt(); // 키를 비교한 회수

		indegree = new int[n + 1];
		adjList = new ArrayList<>();
		sb = new StringBuilder();
		q = new LinkedList<>();

		for (int i = 0; i < n + 1; i++) { // 인덱스가 0번부터 시작하는데, start노드를 그대로 인덱스로 활용할 것이므로 0~n만큼의 리스트 방에 리스트를 할당해 줘야함.
			adjList.add(new ArrayList<>()); // 리스트에 리스트 원소(저장할 공간) 추가하기(add)
		}

		for (int i = 0; i < m; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();

			adjList.get(start).add(end);

			indegree[end]++;
		}

		topologicalSorting(n);

		System.out.println(sb);

	}

}