package top.meethigher;

import org.jline.reader.*;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.OSUtils;

import java.io.IOException;
import java.util.Arrays;

/**
 * 命令行接口
 *
 * @author chenchuancheng github.com/meethigher
 * @since 2023/5/8 22:12
 */
public class CommandLineInterface {
    public static void main(String[] args) throws IOException {
        Terminal terminal;
        if (OSUtils.IS_WINDOWS) {
            terminal = TerminalBuilder.builder()
                    .name("dumb")
                    .dumb(true)
                    .build();
        } else {
            terminal = TerminalBuilder.terminal();
        }
        //Linux terminal支持tab自动补全和搜索。Windows不支持。
        Completer completer = new StringsCompleter(Arrays.asList("help", "quit", "hello"));

        LineReader reader = LineReaderBuilder.builder()
                .terminal(terminal)
                .completer(completer)
                .build();

        String prompt = "cli> ";

        String line;
        while ((line = reader.readLine(prompt)) != null) {
            switch (line) {
                case "help":
                    System.out.println("This is a help message");
                    break;
                case "quit":
                    return;
                case "hello":
                    System.out.println("Hello world!");
                    break;
                default:
                    System.out.println("Unknown command");
            }
        }
    }
}
