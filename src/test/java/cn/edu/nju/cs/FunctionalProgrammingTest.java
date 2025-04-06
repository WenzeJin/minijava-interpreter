package cn.edu.nju.cs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionalProgrammingTest {
    private static final String TEST_CASES_INPUT_DIR = "testcases/input/functional/";
    private static final String TEST_CASES_OUTPUT_DIR = "testcases/output/functional/";

    @BeforeEach
    public void setUp() {
        // 需要的初始化代码
    }

    /**
     * 获取 functional 目录下的所有 .mj 测试文件
     */
    static List<String> provideTestCases() throws IOException, URISyntaxException {
        URL resource = FunctionalProgrammingTest.class.getClassLoader().getResource(TEST_CASES_INPUT_DIR);
        if (resource == null) {
            throw new IllegalStateException("测试输入目录不存在！");
        }

        Path testDir = Paths.get(resource.toURI());
        try (Stream<Path> paths = Files.list(testDir)) {
            return paths
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".mj"))
                    .map(path -> path.getFileName().toString())
                    .collect(Collectors.toList());
        }
    }

    @DisplayName("Functional Programming Tests")
    @ParameterizedTest(name = "Running {0}")
    @MethodSource("provideTestCases")
    public void runFunctionalTest(String testFileName) throws Exception {
        runTest(testFileName);
    }

    private void runTest(String testFileName) throws Exception {
        // // 通过 ClassLoader 读取资源文件
        // InputStream mjInputStream = getClass().getClassLoader().getResourceAsStream(TEST_CASES_INPUT_DIR + testFileName);
        // InputStream expectedOutputStream = getClass().getClassLoader().getResourceAsStream(TEST_CASES_OUTPUT_DIR + testFileName.replace(".mj", ".output"));

        // if (mjInputStream == null || expectedOutputStream == null) {
        //     throw new IllegalStateException("测试输入或输出文件不存在：" + testFileName);
        // }

        // // 读取预期输出（确保流不会被多次消费）
        // String expectedOutput;
        // try (BufferedReader reader = new BufferedReader(new InputStreamReader(expectedOutputStream, StandardCharsets.UTF_8))) {
        //     expectedOutput = reader.lines().collect(Collectors.joining(System.lineSeparator()));
        // }

        // // 将输入流写入临时文件
        // File tempFile = File.createTempFile("test_", ".mj");
        // try (FileOutputStream fos = new FileOutputStream(tempFile)) {
        //     mjInputStream.transferTo(fos);
        // }

        // // 捕获标准输出
        // ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // PrintStream originalOut = System.out;
        // try (PrintStream ps = new PrintStream(outputStream)) {
        //     System.setOut(ps);
        //     Main.run(tempFile);
        // } finally {
        //     System.setOut(originalOut);
        // }

        // // 获取实际输出
        // String actualOutput = outputStream.toString().trim();

        // // 判断输出是否匹配
        // assertEquals(expectedOutput.trim(), actualOutput.trim(), "Output mismatched: " + testFileName);

        // // 清理临时文件
        // tempFile.delete();
    }
}