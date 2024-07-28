    import java.io.*;
    import java.util.*;

    public class Main {
        static class Member {
            int index, age;
            String name;

            public Member(int index, int age, String name) {
                this.index = index;
                this.age = age;
                this.name = name;
            }
        }

        static PriorityQueue<Member> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.age == o2.age) return o1.index - o2.index;
            return o1.age - o2.age;
        });

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int age = Integer.parseInt(st.nextToken());
                String name = st.nextToken();
                pq.add(new Member(i, age, name));
            }

            StringBuilder sb = new StringBuilder();
            while (!pq.isEmpty()) {
                Member member = pq.poll();
                sb.append(member.age).append(" ").append(member.name).append("\n");
            }
            System.out.println(sb);
        }
    }