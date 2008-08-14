/**
 * %SVN.HEADER%
 */
package tutorials.classification;

import java.io.File;
import java.io.IOException;

import net.sf.javaml.classification.Classifier;
import net.sf.javaml.classification.KNearestNeighbors;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.Instance;
import net.sf.javaml.tools.data.FileHandler;

import org.junit.Assert;
import org.junit.Test;

import be.abeel.util.TimeInterval;

/**
 * This tutorial show how to use a the k-nearest neighbors classifier.
 * 
 * @author Thomas Abeel
 * 
 */
public class TutorialKNN {
    /**
     * Shows the default usage of the KNN algorithm.
     */
    @Test
    public void testDefaultKNN() {

        try {
            /* Load a data set */
            Dataset data = FileHandler.loadDataset(new File("devtools/data/iris.data"), 4, ",");
            /*
             * Contruct a KNN classifier that uses 5 neighbors to make a
             * decision.
             */
            Classifier knn = new KNearestNeighbors(5);
            knn.buildClassifier(data);

            /*
             * Load a data set, this can be a different one, but we will use the
             * same one.
             */
            Dataset dataForClassification = FileHandler.loadDataset(new File("devtools/data/iris.data"), 4, ",");
            /* Counters for correct and wrong predictions. */
            int correct = 0, wrong = 0;
            /* Classify all instances and check with the correct class values */
            for (Instance inst : dataForClassification) {
                Object predictedClassValue = knn.classify(inst);
                Object realClassValue = inst.classValue();
                if (predictedClassValue.equals(realClassValue))
                    correct++;
                else
                    wrong++;
            }
            System.out.println("Correct predictions  " + correct);
            System.out.println("Wrong predictions " + wrong);

        } catch (IOException e) {
            Assert.assertTrue(false);
        }

    }

    /**
     * Test KNN usage on the sparse sample.
     * 
     */
    @Test
    public void testSparseKNN() {

        try {
            /* Load a data set */
            Dataset data = FileHandler.loadSparseDataset(new File("devtools/data/sparse.txt.gz"), 0, ";", ":");
            /*
             * Contruct a KNN classifier that uses 5 neighbors to make a
             * decision.
             */
            Classifier knn = new KNearestNeighbors(5);
            knn.buildClassifier(data);
            System.out.println("Building complete!");
            /*
             * Load a data set, this can be a different one, but we will use the
             * same one.
             */
            Dataset dataForClassification = FileHandler.loadSparseDataset(new File("devtools/data/sparse.txt.gz"), 0,
                    ";", ":");
            /* Counters for correct and wrong predictions. */
            int correct = 0, wrong = 0;
            int count=0;
            /* Classify all instances and check with the correct class values */
            for (Instance inst : dataForClassification) {
                long time=System.currentTimeMillis();
                System.out.print("Processing instance: " + ++count+"\t");
                Object predictedClassValue = knn.classify(inst);
                Object realClassValue = inst.classValue();
                if (predictedClassValue.equals(realClassValue))
                    correct++;
                else
                    wrong++;
                System.out.println(new TimeInterval(System.currentTimeMillis()-time));
            }
            System.out.println("Correct predictions  " + correct);
            System.out.println("Wrong predictions " + wrong);

        } catch (IOException e) {
            Assert.assertTrue(false);
        }

    }
}
