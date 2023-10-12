import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static int T, sm, sc, si, memory[], mp, cp, ip, pair[], cnt;
	static char[] command, input;
	static Stack<Integer> s;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sm = Integer.parseInt(st.nextToken());
			sc = Integer.parseInt(st.nextToken());
			si = Integer.parseInt(st.nextToken());
			memory = new int[sm];
			command = br.readLine().toCharArray();
			pair = new int[sc];
			input = br.readLine().toCharArray();
			s = new Stack<>();
			for (int i = 0; i < sc; i++) {
				if (command[i] == '[') {
					s.push(i);
				} else if (command[i] == ']') {
					int idx = s.pop();
					pair[i] = idx;
					pair[idx] = i;
				}
			}
			mp = 0; ip = 0; cp = 0; cnt = 0;
			while (cnt <= 50000000 && cp < sc) {
				process();
				cnt++;
			}
			if (cp == sc) System.out.println("Terminates");
			else {
				int open = cp;
				int close = cp;
				while (cnt-- > 0) {
					process();
					open = Math.min(open, cp);
					close = Math.max(close, cp);
				}
				System.out.println("Loops " + (open - 1) + " " + close);
			}
		}
		
	}
	
	private static void process() {
		if (command[cp] == '-') {
			if (--memory[mp] < 0) memory[mp] = 255;
		} else if (command[cp] == '+') {
			if (++memory[mp] > 255) memory[mp] = 0;
		} else if (command[cp] == '<') {
			mp = (mp + sm - 1) % sm;
		} else if (command[cp] == '>') {
			mp = (mp + 1) % sm;
		} else if (command[cp] == '[') {
			if (memory[mp] == 0) cp = pair[cp];
		} else if (command[cp] == ']') {
			if (memory[mp] != 0) cp = pair[cp];
		} else if (command[cp] == ',') {
			if (ip < si) memory[mp] = (int)input[ip++];
			else memory[mp] = 255;
		}
		cp++;
	}

}
