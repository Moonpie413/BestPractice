package org.wxh.bestpractice.current.concurrency_in_practice.Example6_15;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by wangxh on 16-12-26.
 * Package org.wxh.bestpractice.current.concurrency_in_practice.Example6_15
 * DES:
 */

abstract class Info {}

class TextInfo extends Info {}

class ImageInfo extends Info {

    private String imageName;

    public ImageInfo(String imageName) {
        this.imageName = imageName;
    }

    /**
     * 这段代码放在callable中执行
     * @return
     */
    public ImageData downloadImages() {
        try {
            System.out.println("start to download image: " + imageName + "from " + Thread.currentThread().getName());
            Date start = new Date();
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
            System.out.println("download image " + imageName + "finished, use " + (
                    new Date().getTime() - start.getTime()) + "mis");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ImageData(imageName);
    }
}

class ImageData {
    private String dataName;

    public ImageData(String dataName) {
        this.dataName = dataName;
    }

    public String getData() {return "this is data from " + this.dataName;}
}

public class Renderer {
    private final ExecutorService executor;

    public Renderer(ExecutorService executor) {
        this.executor = executor;
    }

    private List<ImageInfo> scanImageInfos(List<Info> infos) {
        List<ImageInfo> result = new ArrayList<>();
        infos.forEach(element -> {
            if (element instanceof ImageInfo) result.add((ImageInfo) element);
        });
        return result;
    }

    private void renderText() {
        System.out.println("rendering Text");
        Date start = new Date();
        try {
            TimeUnit.MILLISECONDS.sleep(1200);
            System.out.println("render Text finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void renderImage(ImageData imageData) {
        System.out.println(imageData.getData());
    }

    public void renderPage(List<Info> infos) {
        List<ImageInfo> imageInfos = scanImageInfos(infos);
        CompletionService<ImageData> service = new ExecutorCompletionService<ImageData>(executor);
        for (final ImageInfo imageInfo : imageInfos) {
            service.submit(imageInfo::downloadImages);
        }
        renderText();
        try {
            for (int i = 0; i < imageInfos.size(); i++) {
                Future<ImageData> future = service.take();
                renderImage(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        try {
            List<Info> infos = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                if (i == 1) infos.add(new TextInfo());
                infos.add(new ImageInfo("image { " + i + " }"));
            }
            new Renderer(exec).renderPage(infos);
        } finally {
            exec.shutdown();
        }
    }
}
