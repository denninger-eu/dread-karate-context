package eu.k5.dread.soapui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DreadAssertionTest {
    SoapuiContext context = new SoapuiContext();

    @Test
    public void jsonExists_withExistingJson_true() {
        SoapuiContext.RestRequestContext step = context.requestStep("step");
        step.response("{\"key\":\"value\"}");
        Assertions.assertTrue(step.assertJsonExists("$.key"));
    }

    @Test
    public void jsonExists_withNotExistingJson_false() {
        SoapuiContext.RestRequestContext step = context.requestStep("step");
        step.response("{\"key\":\"value\"}");
        Assertions.assertFalse(step.assertJsonExists("$.key2"));
    }

    @Test
    public void jsonExists_withItemInArray_true() {
        SoapuiContext.RestRequestContext step = context.requestStep("step");
        step.response("[{\"key\":\"value\"}]");
        Assertions.assertTrue(step.assertJsonExists("$[0].key"));
    }

    @Test
    public void jsonExists_withEntity_true() {
        SoapuiContext.RestRequestContext step = context.requestStep("step");
        step.response("[{\"key\":\"value\"}]");
        Assertions.assertTrue(step.assertJsonExists("$[0]"));
    }


}