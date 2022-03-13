package kz.springboot.demoProjectSB.beans

import org.springframework.stereotype.Component

@Component
public class TestBean
{
    private String text = "Hello";

    public TestBean() {
        println ("Creating test bean");
    }

    public void SetText(String text)
    {
        this.text = text;
    }

    public String getData()
    {
        return 'this is' + this.text + " data";
    }
}
