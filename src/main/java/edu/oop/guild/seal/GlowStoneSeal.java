package edu.oop.guild.seal;

public class GlowStoneSeal implements PackageSeal{
	@Override
    public String apply(String label) {
        if (label == null) throw new NullPointerException();
        return "◆ " + label + " ◆";
    }

    @Override
    public int durability() {
        return 12;
    }
}
