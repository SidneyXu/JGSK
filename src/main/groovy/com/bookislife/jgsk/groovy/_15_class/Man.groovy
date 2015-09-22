package com.bookislife.jgsk.groovy._15_class

/**
 * Created by SidneyXu on 2015/09/22.
 */
class Man {

    def name
    def age
    private def from = "USA"
    def description = "none"

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Man{");
        sb.append("name=").append(name).append("'");
        sb.append(", age=").append(age).append("'");
        sb.append(", from=").append(from).append("'");
        sb.append(", description=").append(description).append("'");
        sb.append('}');
        return sb.toString();
    }
}
