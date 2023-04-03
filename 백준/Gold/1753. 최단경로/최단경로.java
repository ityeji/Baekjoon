import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

//node클래스 만들기
// 우선순위 큐에 정점 번호 + 가중치 저장을 위해 만드는 것

class Node {

	int idx; // 정점번호
	int weight; // 가중치

	public Node(int idx, int weight) { // 생성자
		this.idx = idx;
		this.weight = weight;
	}

	// 여기서 클래스에 implements Comparable<Node>해서 compareTo() 오버라이딩 해서 인스턴스간 정렬 할 수 있지만,
	// 나는 그냥 우선순위 큐에 바로 정렬 시킬 거지롱
	// 만약 여기서 정렬 한다면?

	// @Override
	// public int compareTo(Node o){
	// return Integer.compare(this.cost, o.cost);
	// }
}

public class Main {

	static Scanner sc = new Scanner(System.in);

	// 다익스트라 알고리즘
	// 그래프의 최단 경로 구하는 알고리즘
	// 우선순위 큐를 이용하용 시간 복잡도가 개선된다 -> 개선된 다익스트라 알고리즘

	// 1. 아직 방문하지 않은 정점 중 출발지로부터 가장 거리가 짧은 정점을 방문한다.
	// 2. 해당 정점을 거쳐 갈 수 있는 정점의 거리가 이전 기록한 값보다 적으면 갱신한다.

	// 인접 리스트 그래프 + 우선순위 큐 사용

	static PriorityQueue<Node> pq; // 우선순위 큐
	// 정점과 출발지에서 정점까지 가는 최소 거리 저장

	static boolean[] check; // 해당 정점을 방문하는지 체크
	static int[] dist; // 출발지에서 최소 거리 기록

	static List<Node>[] adjList;

	static int INF;

	static int v;

	public static void main(String[] args) {

		v = sc.nextInt(); // 정점 개수
		int e = sc.nextInt(); // 간선 개수

		dist = new int[v + 1];

		check = new boolean[v + 1];
		// dist 배열은 무한대 값으로 초기화
		// 원래 값보다 작으면 원소를 갱신하는 쪽으로 구현할 것이므로
		INF = Integer.MAX_VALUE;
		Arrays.fill(dist, INF);

		adjList = new ArrayList[v + 1]; // 방 몇 개인지만 정해주고

		for (int i = 0; i <= v; i++) {
			adjList[i] = new ArrayList<>(); // 실제 저장할 공간 만들어줌
		}

		int start = sc.nextInt(); // 출발지
		// 출발지 정점과 가중치를 우선순위큐에 넣는다.

		for (int i = 0; i < e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();

			// 유향그래프
			adjList[a].add(new Node(b, w)); // 인접리스트 노드 추가
		}

		dijkstra(start);

	}

	public static void dijkstra(int node) {

		dist[node] = 0;

		pq = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.weight, o2.weight)); // 각 인스턴스의 가중치weight에 따라 오름차순으로
		// 정렬됨.

		pq.offer(new Node(node, 0));

		while (!pq.isEmpty()) {
			int nowIdx = pq.poll().idx; // 끝 정점

			if (check[nowIdx]) {
				// 끝 정점이 true이면 그냥 넘어가
				continue;
			}

			// 아니면?
			check[nowIdx] = true;

			for (Node next : adjList[nowIdx]) {
				// 끝정점을 시작정점으로 하는 인접 리스트(리턴 형식: Node 클래스)를 뽑아 next변수에 넣기
				if (dist[next.idx] > dist[nowIdx] + next.weight) {
					// 현재 정점에서 끝 정점으로의 거리가
					// 이전 정점부터 현재 정점까지의 거리 + 다음 정점까지의 가중치보다 크면
					// 갱신
					dist[next.idx] = dist[nowIdx] + next.weight;

					// 새로 갱신된 값을 우선순위큐에 넣기
					pq.offer(new Node(next.idx, dist[next.idx]));
				}
			}
		}

		for (int i = 1; i < v + 1; i++) {
			if (dist[i] == INF) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}

	}
}