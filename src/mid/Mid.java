package mid;

/*
    Use Case Diagram – shows in a single diagram all the use cases for the system
    - Class Diagram – shows attributes and operations in each of the (primary)
    classes of the system as well as relationships between them. Used in the Static
    Model during analysis, and later in design
    - Sequence Diagram – shows the flow of communication between the
    running objects of the system, driven by the use cases of the system (e.g.: In an
    ATM system, a use case “withdraw money”; a sequence diagram will show how
    the system processes the request to withdraw money). Used for the Dynamic Model.
    - Object Diagram – shows how, at a particular moment in time, all the
    instances of the classes communicate with each other. This is part of the
    Dynamic Model (not discussed in this course)
    - Many Others! [See the sample diagrams in the materials accompanying this lecture]


    Use case
    A Use Case is a sequence of steps performed by a user, interacting with the system, for the purpose of achieving some goal.

    User Story
    A user story is a short, simple description of a feature or requirement from the perspective of an end user.
    It typically follows this format:

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

public class Mid {


    public static void main(String[] args) {


        List<String> s = new ArrayList(Arrays.asList("11", 22));

        ArrayList l = new ArrayList<Integer>() {{
            add(1);
            add(3);
            add(4);
        }};

    }

    public static int print(Object i) {
        System.out.println("printing " + i);
        return 0;
    }

}
