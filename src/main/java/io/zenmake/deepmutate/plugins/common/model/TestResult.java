package io.zenmake.deepmutate.plugins.common.model;

/**
 * Created by Talal Ahmed on 22/02/2023
 */
public class TestResult {

    public static final String STATUS_PASSED = "passed";
    public static final String STATUS_FAILED = "failed";
    public static final String STATUS_SKIPPED = "skipped";
    public static final String STATUS_COMPLETE = "complete";

    private String id;

    private String className;

    private String methodName;

    private String descriptor;

    private String stacktrace;

    private long startTime;

    private long endTime;

    private String status;

    public TestResult() {
    }

    public TestResult(String status) {
        this.status = status;
    }

    public static TestResult createPassed(long startTime, long endTime, String descriptor) {
        return create(startTime, endTime, descriptor, TestResult.STATUS_PASSED);
    }

    public static TestResult createSkipped(long startTime, long endTime, String descriptor) {
        return create(startTime, endTime, descriptor, TestResult.STATUS_SKIPPED);
    }

    public static TestResult createFailed(long startTime, long endTime, String descriptor) {
        return create(startTime, endTime, descriptor, TestResult.STATUS_FAILED);
    }

    public static TestResult create(long startTime, long endTime, String descriptor, String status) {
        var result = new TestResult(status);
        result.setStartTime(startTime);
        result.setEndTime(endTime);
        result.setDescriptor(descriptor);
        return result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public String getStacktrace() {
        return stacktrace;
    }

    public void setStacktrace(String stacktrace) {
        this.stacktrace = stacktrace;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", descriptor='" + descriptor + '\'' +
                ", stacktrace='" + stacktrace + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
