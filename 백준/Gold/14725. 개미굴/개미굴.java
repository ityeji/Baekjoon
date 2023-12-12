import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
// 1. Node 만들기
	static class TrieNode {
		// 자식 노드
		Map<String, TrieNode> chiledNode = new HashMap<>();
//		Map<Character, TrieNode> chiledNode = new HashMap<>();

		TrieNode() {
		}

		public void insert(String strs) {
			TrieNode trieNode = this;
			String[] str = strs.split(",");
			for (String s : str) {
				trieNode.chiledNode.putIfAbsent(s, new TrieNode()); // Map에서 Key값을 Character가 아니라, String으로 해줘야함!
				trieNode = trieNode.chiledNode.get(s); // trieNode는 s를 키로 가진 자식 노드로 업데이트
			}
		}

		public void print(TrieNode cur, int depth) {
			TrieNode trieNode = cur;
			if (trieNode.chiledNode != null) { // 자식노드가 있다면!
				List<String> list = new ArrayList<>(trieNode.chiledNode.keySet()); // 자식노드의 key들을 리스트업!
				// 사전순으로 정렬!
				Collections.sort(list);
				for (String str : list) {
					for (int i = 0; i < depth; i++) {
						System.out.print("--");
					}
					System.out.println(str);
					print(trieNode.chiledNode.get(str), depth + 1);
				}
			}
		}
	}

	public static void main(String[] args) {
		// Trie
		// Map interface를 사용해서 구현 Map<Character, Node>
		// 사전 검색 알고리즘
		// Map의 키 값 -> 문자를 이루는 각각의 단어들
		// 키와 매칭되는 값 -> 자식 노드 클래스
		// 문자가 현재 trie 내부에 존재하는지 체크하기위한 boolean 변수도 추가적으로 사용해야 함

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.nextLine();

		TrieNode trie = new TrieNode();

		for (int i = 0; i < n; i++) {
			int k = sc.nextInt();

			// 중간에 공백이 있으니, Scanner.next로 받아서 StringBuilder에 구분문자 ","로 넣어주자!
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < k; j++) {
				sb.append(sc.next()).append(",");
			}
			trie.insert(sb.toString());
		}
		trie.print(trie, 0);
	}

}