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

import hudson.model.Result;
import org.apache.commons.io.FilenameUtils;

import java.util.Random;
import java.util.Set;

/**
 * This class provides various Bob Ross' styles.
 * @author cliffano
 */
public enum Style {

    PORTRAIT,
    PAINTING,
    CHIPMUNK;

    /**
     * Gets the style corresponding to the build result.
     * @param result
     *            the build result
     * @return the style
     */
    public static final String get(final Result result) {
        Style style;

        // Get all files
        File file = new File();
        Set<String> foundFiles;
        String randomFileName = "painting"; // Set a default painting for when something fails with the randomizer code

        // Determine what the image should be
        if (Result.FAILURE.equals(result)) {
            // Get a comforting portait of a confident and forgiving man when your build fails.
            style = PORTRAIT;
        } else if (Result.SUCCESS.equals(result)) {
            // Get a beautiful piece of landscape with the possibility of happy little trees as a reward for successful builds.
            style = PAINTING;
        } else {
            // Get a confused but cute and fuzzy little animal when things are a bit unstable.
            style = CHIPMUNK;
        }

        // Find files related to the style
        System.out.println("### Style "+style.toString().toLowerCase());
        foundFiles = file.findFiles(style.toString().toLowerCase());
        System.out.println("### Files "+foundFiles.toString());

        // Pick a random file from the files found
        int size = foundFiles.size();
        if(size > 0){
            System.out.println("### "+size+" is greater than 0.");
            int item = new Random().nextInt(size);
            int i = 0;
            for(String foundFile : foundFiles)
            {
                if (i == item)
                    randomFileName = FilenameUtils.getBaseName(foundFile);
                i++;
            }
        } else {
            System.out.println("### "+size+" is not greater than 0.");
        }

        return randomFileName;
    }
}
