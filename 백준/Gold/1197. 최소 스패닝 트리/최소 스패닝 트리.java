import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	static int v; // 정점의 개수

	static PriorityQueue<int[]> pQueue; // 우선순위큐

	static int[] parent; // 각 정점마다 부모 저장

	static int[] rank; // 트리 높이 저장

	static int totalWeight; // 가중치 합 저장

	public static void input() {

		v = sc.nextInt();

		int e = sc.nextInt();

		parent = new int[v + 1];
		rank = new int[v + 1];

		makeSet();

		pQueue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2] - o2[2];
			}
		});

		for (int i = 0; i < e; i++) {
			int node1 = sc.nextInt();

			int node2 = sc.nextInt();

			int weight = sc.nextInt();

			pQueue.offer(new int[] { node1, node2, weight });
		}

		solved();
	}

	public static void makeSet() {

		for (int i = 1; i < v + 1; i++) {
			parent[i] = i;
			rank[i] = 0;
		}
	}

	public static int findParent(int x) {

		if (parent[x] == x)
			return x;
		else
			return parent[x] = findParent(parent[x]);
	}

	public static void union(int x, int y) {
		if (findParent(x) == findParent(y)) {
			return;
		}

		if (rank[x] > rank[y]) {
			parent[findParent(y)] = findParent(x);
		} else {
			parent[findParent(x)] = findParent(y);

			if (rank[x] == rank[y]) {
				rank[y]++;
			}
		}
	}

	public static void solved() {

		totalWeight = 0; // 가중치 합
		// 어차피 큐에서 오름차순으로 정렬되어 가중치가 최소인 것부터 나옴

		while (!pQueue.isEmpty()) {
			int[] data = pQueue.poll();

			int node1 = data[0];
			int node2 = data[1];
			int weight = data[2];

			if (findParent(node1) == findParent(node2)) {
				continue;
			}

			union(node1, node2);

			totalWeight += weight;
		}
	}

	public static void main(String[] args) {

		input();
		System.out.println(totalWeight);
	}

}