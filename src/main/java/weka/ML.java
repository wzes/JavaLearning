package weka;

import weka.classifiers.Classifier;
import weka.classifiers.trees.RandomForest;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.ArffLoader;

import java.io.File;
import java.io.IOException;

/**
 * @author Create by xuantang
 * @date on 9/3/18
 */
public class ML {
    public static void main(String[] args) throws Exception {
        Classifier m_classifier = new RandomForest();
        File inputFile = new File("data/trainData.arff");
        ArffLoader atf = new ArffLoader();
        atf.setFile(inputFile);
        Instances instancesTrain = atf.getDataSet();
        inputFile = new File("data/testData.arff");
        atf.setFile(inputFile);
        Instances instancesTest = atf.getDataSet();
        instancesTest.setClassIndex(0);
        double sum = instancesTest.numInstances(), right = 0.0f;
        instancesTrain.setClassIndex(0);
        m_classifier.buildClassifier(instancesTrain);
        System.out.println(m_classifier);

        SerializationHelper.write("data/LibSVM.model", m_classifier);

        for (int i = 0; i < sum;i++) {
            if(m_classifier.classifyInstance(instancesTest.instance(i)) == instancesTest.instance(i).classValue()) {
                right++;
            }
        }

        // 获取上面保存的模型
        Classifier classifier8 = (Classifier) weka.core.SerializationHelper.read("data/LibSVM.model");
        double right2 = 0.0f;
        for (int i = 0; i < sum; i++) {
            System.out.println(classifier8.classifyInstance(instancesTest.instance(i)));
            System.out.println(instancesTest.instance(i).classValue());
            if  (classifier8.classifyInstance(instancesTest.instance(i)) == instancesTest.instance(i).classValue()) {
                right2++;
            }
        }
        System.out.println(right);
        System.out.println(right2);
        System.out.println(sum);
        System.out.println("RandomForest classification precision:" + (right/sum));
    }
}
