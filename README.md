使用Java基于JLine3实现的Cli式风格

1. 历史记录
2. TAB自动补全。*Jline3不支持Windows默认命令提示符（cmd.exe）上的Tab自动补全，因为它实现了基于ANSI转义序列的自动补全，而Windows默认命令提示符（cmd.exe）不支持这些ANSI转义序列。*