package com.DsaProject.IntPack.supports;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

class MemoryMappedFileExample {
    public static void main(String[] args) throws Exception {
        RandomAccessFile file = new RandomAccessFile("data.txt", "rw");
        FileChannel channel = file.getChannel();

        MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 1024);

        buffer.put(0, (byte) 'H');
        buffer.put(1, (byte) 'i');

        channel.close();
        file.close();
    }
}
