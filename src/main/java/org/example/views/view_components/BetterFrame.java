package org.example.views.view_components;

import javax.swing.*;

public class BetterFrame
    extends JFrame
{

    public BetterFrame(String title)
    {
        super(title);
        commonInit();
    }

    public BetterFrame()
    {
        super();
        commonInit();
    }


    public void commonInit()
    {
        setIconImage(new ImageIcon("src/main/resources/horoz-logo.png").getImage());
    }

}
