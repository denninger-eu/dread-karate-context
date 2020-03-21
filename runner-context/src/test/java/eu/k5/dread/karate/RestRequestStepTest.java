package eu.k5.dread.karate;

import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class RestRequestStepTest {

    RunnerContext context = new RunnerContext();
    RunnerContext.RestRequestContext request = context.requestStep("test");

    @Test
    void urlSetAndGet() {
        request.url("urlValue");
        Assertions.assertEquals("urlValue", request.url());
    }

    @Test
    @Disabled
    void urlSetAndReadExpanded() {

    }

    @Test
    void responseSetArrayAndGet() {
        JSONArray array = new JSONArray();
        array.add(1);
        request.response(array);
        Assertions.assertEquals("[1]", request.response());
    }

    @Test
    void requestSetAndGet() {
        request.request("{}");
        Assertions.assertEquals("{}", request.request());
    }

    @Test
    void assertJsonExists_existsInJson() {
        request.response("{\"id\": \"val\"}");
        Assertions.assertTrue(request.assertJsonExists("$.id"));
    }

}
