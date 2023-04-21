import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
    int x,y;
    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int dx[] = {-1,-2,-2,-1,1,2,2,1};
    static int dy[] = {-2,-1,1,2,2,1,-1,-2};
    static int [][] arr;
    static boolean [][] check;
    static int x,y,ex,ey,N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-->0){
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            check = new boolean[N][N];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            check[x][y] = true;

            st = new StringTokenizer(br.readLine()," ");
            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());

            bfs();
        }
    }

    private static void bfs() {

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y));

        while (!q.isEmpty()){
            int len = q.size();
            for (int j = 0; j < len; j++) {
                Point poll = q.poll();
                if(poll.x == ex && poll.y == ey){
                    break;
                }
                for (int i = 0; i < 8; i++) {
                    int nx = poll.x + dx[i];
                    int ny = poll.y + dy[i];

                    // 범위 체크
                    if(0<= nx && nx < N && 0<= ny && ny < N){
                        // 방문 체크
                        if(!check[nx][ny] && arr[nx][ny]==0){
                            check[nx][ny] = true;
                            arr[nx][ny] = arr[poll.x][poll.y]+1;
                            q.offer(new Point(nx,ny));
                        }
                    }
                }
            }
        }
        System.out.println(arr[ex][ey]);
    }
}