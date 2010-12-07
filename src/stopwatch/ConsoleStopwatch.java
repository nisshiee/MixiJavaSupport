package stopwatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * CUIで実装したストップウォッチ
 */
public class ConsoleStopwatch {

	/**
	 * エントリポイント
	 * 
	 * @param args
	 *            特に無し
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.print("Start > push enter, Exit > input \"exit\": ");
			String input = br.readLine();
			if (input.equals("exit")) {
				break;
			}
			long start = System.currentTimeMillis();
			System.out.print("Stop > push enter: ");
			br.readLine();
			long end = System.currentTimeMillis();
			String time = millisecToStr(end - start);
			System.out.println(time);
		}
	}

	/**
	 * 時間（ミリ秒）を表すlong値から文字列を生成
	 * 
	 * @param millisec
	 *            時間（ミリ秒）
	 * @return 時間を表す文字列
	 */
	public static String millisecToStr(long millisec) {
		if (millisec < 0l) {
			throw new IllegalArgumentException();
		}
		long milli = millisec % 1000l;
		long sec = millisec / 1000l;
		long min = sec / 60l;
		if (min == 0) {
			return String.format("%02d.%03d", sec, milli);
		}
		sec %= 60l;
		long hour = min / 60l;
		if (hour == 0) {
			return String.format("%02d:%02d.%03d", min, sec, milli);
		}
		min %= 60l;
		return String.format("%d:%02d:%02d.%03d", hour, min, sec, milli);
	}
}
