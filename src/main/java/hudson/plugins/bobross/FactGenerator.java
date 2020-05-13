/**
 * Copyright (c) 2009 Cliffano Subagio
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package hudson.plugins.bobross;

import java.util.Random;

/**
 * {@link FactGenerator} provides Bob Ross facts.
 * @author cliffano
 */
public class FactGenerator {

    // Original Bob Ross quotes found here: https://www.goodreads.com/author/quotes/102372.Bob_Ross
      
    private static final String[] FACTS = {
            "There are no bugs or failed pipelines, there are only happy little accidents.",
            "Keeping your pipeline green is a pursued interest. Anything that you're willing to practice, you can do.",
            "There's nothing wrong with having a failing pipeline as a friend.",
            "I guess I’m a little weird. I like to talk to my cicd tools. That’s okay though; I have more fun than most people.",
            "Let's get crazy.",
            "I can't think of anything more rewarding than being able to express yourself to others through rigid deployment pipelines. Exercising the imagination, experimenting with talents, being creative; these things, to me, are truly the linux to your soul.",
            "The secret to doing anything is believing that you can do it. Anything that you believe you can do strong enough, you can do. Anything. As long as you believe.",
            "All you need to automate is a few tools, a little instruction, and a vision in your mind.",
            "See a Windows machine, just beats the devil out of it. *chuckles*",
            "Mix up a little more pipeline dsl here, then we can put us a bash script right in there. See how you can move things around? You have unlimited power on this server -- can literally, literally move files across the world",
            "Believe that you can do it cause you can do it.",
            "I started messing around with Linux as a hobby when I was little. I didn't know I had any talent. I believe talent is just a pursued interest. Anybody can do what I do.",
            "This is your world. You’re the creator. Find freedom on this automation server. Believe, that you can do it, 'Cuz you can do it. You can do it.",
            "Let's provision a happy little cloud. Lets build some happy little applications.",
            "There's nothing in the world that breeds success like success.",
            "Let's get a little crazy here.",
            "What can be scripted can be punished.",
            "On AWS there are no mistakes, only happy little catastrophes.", 
            "Now then, let's come right down in here and put some nice big strong naming conventions on these git branches. Branch needs an fork too. It'll hold up the weight of the repository. Little webhook has to have a place to set there. There he goes...",
            "Bob Ross doesn't throw exceptions, he cannot help but put them down gently and admire them for being their own unique selves.",
            "Bob Ross uses revision control software so he can look back on his mistakes and learn from them.",
            "Bob Ross' afro isn't immutable, if it could ask nicely Bob would probably be inclined to change his style."
          };

    /**
     * Random instance.
     */
    private static final Random RANDOM = new Random();

    /**
     * Retrieves a random fact.
     * @return a random fact
     */
    public String random() {
        return FACTS[RANDOM.nextInt(FACTS.length)];
    }
}
