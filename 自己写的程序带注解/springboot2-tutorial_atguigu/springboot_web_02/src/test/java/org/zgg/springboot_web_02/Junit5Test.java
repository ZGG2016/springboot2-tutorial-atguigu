package org.zgg.springboot_web_02;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("junit5功能测试类")
public class Junit5Test {

    @Test
    @DisplayName("fail")
    public void shouldFail() {
        fail("This should fail");
    }

    @Test
    @DisplayName("超时测试")
    public void timeoutTest() {
        //如果测试方法时间超过1s将会异常
        assertTimeout(Duration.ofMillis(1000), () -> Thread.sleep(500));
    }

    @Test
    @DisplayName("异常测试")
    public void exceptionTest() {
        ArithmeticException exception = Assertions.assertThrows(
                //扔出断言异常
                ArithmeticException.class, () -> System.out.println(1 % 0));

    }

    @Test
    @DisplayName("assert all")
    public void all() {
        assertAll("Math",
                () -> assertEquals(2, 1 + 1),
                () -> assertTrue(1 > 0)
        );
    }

    @Test
    @DisplayName("array assertion")
    public void array() {
        assertArrayEquals(new int[]{1, 2}, new int[] {1, 2});
    }

    // 前面断言失败，后面的代码都不会执行
    @Test
    public void testSimpleAssertions(){
        int res = cal(2, 2);
        assertEquals(4,res,"计算逻辑失败");
//        assertEquals(5,res,"计算逻辑失败");

        Object o1 = new Object();
        Object o2 = new Object();
        assertSame(o1,o2,"对象不同");

    }

    public int cal(int i,int j){
        return i+j;
    }

    @Test
    public void testAssumptions(){
//        Assumptions.assumeTrue(true,"结果不为true");
        Assumptions.assumeTrue(false,"结果不为true");
        System.out.println("testAssumptions");
    }

    /*
     * @BootstrapWith(SpringBootTestContextBootstrapper.class)
       @ExtendWith({SpringExtension.class})
       public @interface SpringBootTest {}
     * */

    @Tag("fast")
    @Test
    public void test4() {
        System.out.println("test4");
    }

    @RepeatedTest(3)
    public void test3() {
        System.out.println("test3");
    }

//    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
//    @Test
//    public void testTimeout() throws InterruptedException {
//        Thread.sleep(600);
//    }

    @DisplayName("测试方法1")
    @Test
    public void testDisplayName(){
        System.out.println("测试方法1");
    }

    @Disabled
    @DisplayName("测试方法2")
    @Test
    public void test2(){
        System.out.println("测试方法2");
    }


//    @BeforeEach
//    public void testBeforeEach(){
//        System.out.println("测试即将开始.............");
//    }
//
//    @AfterEach
//    public void testAfterEach(){
//        System.out.println("测试结束.............");
//    }

    @BeforeAll
    static public void testBeforeAll(){
        System.out.println("所有测试即将开始.............");
    }

    @AfterAll
    static public void testAfterAll(){
        System.out.println("所有测试结束.............");
    }
}
