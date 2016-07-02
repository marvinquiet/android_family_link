package com.example.marvin.familylink._UI._Utils;

import android.graphics.Bitmap;
import android.util.LruCache;



// To change object to class and change class to object

public class Utils {
    public static LruCache<String, Bitmap> imageCache;
    /*     Cache   */
//    public static void initCache() {
//        // memory cache for data
//        memoryCache = new MemoryCache();
//
//        // memory cache for image
//        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
//        // Use 1/8th of the available memory for this memory cache.
//        final int cacheSize = maxMemory / 8;
//
//        imageCache = new LruCache<String, Bitmap>(cacheSize) {
//            @Override
//            protected int sizeOf(String key, Bitmap bitmap) {
//                // The cache size will be measured in kilobytes rather than
//                // number of items.
//                return bitmap.getByteCount() / 1024;
//            }
//        };
//    }
//
//    public static boolean putMessageInCache(List<MessageContent.Message> messageList) {
//        if (messageList != null) {
//            memoryCache.put(Constants.MESSAGE_MEMORY_KEY, messageList);
//
//            if (BLog.logEnable == true) {
//                for (int i = 0; i < messageList.size(); i++) {
//                    BLog.d("###Message List: " + messageList.get(i).getTitle());
//                }
//            }
//            return true;
//        }
//        return false;
//    }
//
//    public static boolean putFriendsInCache(List<AVUser> friendList) {
//        if (friendList != null) {
//            memoryCache.put(Constants.FRIEND_MEMORY_KEY, friendList);
//
//            if (BLog.logEnable == true) {
//                for (int i = 0; i < friendList.size(); i++) {
//                    BLog.d("###Friend List: " + friendList.get(i).getUsername());
//                }
//            }
//            return true;
//        }
//        return false;
//    }
//
//    public static boolean putRecommendFriendsInCache(List<AVUser> recommendFriendList) {
//        if (recommendFriendList != null) {
//            memoryCache.put(Constants.RECOMMEND_FRIEND_MEMORY_KEY, recommendFriendList);
//
//            if (BLog.logEnable == true) {
//                for (int i = 0; i < recommendFriendList.size(); i++) {
//                    BLog.d("###Friend List: " + recommendFriendList.get(i).getUsername());
//                }
//            }
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     *  Save memory first, then file.
//     */
//    public static void saveUserMemoryThenFile(Context context, List<AVUser> userList, String key) {
//        Utils.memoryCache.put(key, userList);
//
//        FileCache fileCache = null;
//        try {
//            fileCache = FileCache.getFileCache(context);
//            fileCache.saveUserObject(key, userList);
//            fileCache.saveUserListPhoto(userList);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void saveTaskrMemoryThenFile(Context context, List<Task> taskList, String key) {
//        Utils.memoryCache.put(key, taskList);
//
//        FileCache fileCache = null;
//        try {
//            fileCache = FileCache.getFileCache(context);
//            fileCache.saveTaskObject(key, taskList);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * Read memory first, then file.
//     */
//    public static List<AVUser> readUserMemoryThenFile(Context context, String key, String type) {
//        List<AVUser> userList = (List<AVUser>) Utils.memoryCache.get(key);
//        FileCache fileCache = null;
//        try {
//            fileCache = FileCache.getFileCache(context);
//            if (userList == null) {
//                userList = fileCache.readUserObject(key);
//            }
//
//            if (userList != null && type != null) {
//                for (int i = 0; i < userList.size(); i++) {
//                    userList.get(i).put(Constants.EVENT_TYPE, type);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return userList;
//    }
//
//    public static List<Task> readTaskMemoryThenFile(Context context, String key, String type) {
//        List<Task> taskList = (List<Task>) Utils.memoryCache.get(key);
//        FileCache fileCache = null;
//        try {
//            fileCache = FileCache.getFileCache(context);
//            if (taskList == null) {
//                taskList = fileCache.readTaskObject(key);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return taskList;
//    }
//
//
//
//    /**
//     * Judge network, and show dialog or toast.
//     * @param context
//     * @return
//     */
//    public static boolean isNetworkAvailable(Context context) {
//        ConnectivityManager connectivityManager
//                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
//        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
//    }
//
//    public static void showConnectionNADialog(final Context context){
//        MaterialDialog messageDialog = new MaterialDialog.Builder(context)
//                .title("网络故障")
//                .content("是否检查网络状况？")
//                .positiveText("好的")
//                .negativeText("不了，谢谢")
//                .cancelable(false)
//                .callback(new MaterialDialog.ButtonCallback() {
//                    @Override
//                    public void onPositive(MaterialDialog dialog) {
//                        super.onPositive(dialog);
//                        dialog.dismiss();
//                        Intent intent = new Intent(Settings.ACTION_SETTINGS);
//                        context.startActivity(intent);
//                    }
//
//                    @Override
//                    public void onNegative(MaterialDialog dialog) {
//                        super.onNegative(dialog);
//                        dialog.dismiss();
//                    }
//                })
//                .autoDismiss(true)
//                .show();
//    }
//
//    public static void showConnectionNAToast(Context context) {
//        Toast.makeText(context, "当前无网络连接", Toast.LENGTH_LONG).show();
//    }
//
//    /*  Object to Class   */
//    public static Task objectToTask(AVObject taskObject, String taskType) {
//        Task task = new Task();
//        List<AVUser> receivers = new ArrayList<AVUser>();
//        List<Answer> answers = new ArrayList<Answer>();
//
//        if (taskType.equals("unrepliedTask")) {
//            receivers = null;
//            answers = null;
//        } else {
//            AVRelation<AVUser> userAVRelation = taskObject.getRelation(Task.RECEIVERS);
//            AVRelation<AVObject> answerAVRelation = taskObject.getRelation(Task.ANSWERS);
//
//            try {
//                receivers = userAVRelation.getQuery().find();
//
//                for (AVObject answer : answerAVRelation.getQuery().find()) {
//                    answers.add(objectToAnswer(answer));
//                }
//            } catch (AVException e) {
//                e.printStackTrace();
//            }
//        }
//
//        // TODO All error handlers
//        // if failed at any api, what should I do?
//
////        AVObject messageObject = taskObject.getAVObject(taskMsg);
////        MessageContent.Message message = objectToMessage(messageObject);
//        DateFormat fmt = new SimpleDateFormat("MM-dd HH:mm:ss");
//        String time = fmt.format(taskObject.getUpdatedAt());
//
//        task.setObjectId(taskObject.getObjectId());
////        task.setSender(taskObject.getAVUser(taskSender));
//        String senderId = taskObject.getAVUser(Task.SENDER).getObjectId();
//        try {
//            task.setSender(AVUser.getQuery().get(senderId));
//        } catch (AVException e) {
//            e.printStackTrace();
//        }
//        task.setReceivers(receivers);
//
//        String messageId = taskObject.getAVObject(Task.MSG).getObjectId();
//        AVQuery<AVObject> query = new AVQuery<>(Constants.MESSAGE);
//
////        task.setMsg(objectToMessage(taskObject.getAVObject(taskMsg)));
//        try {
//            task.setMsg(objectToMessage(query.get(messageId)));
//        } catch (AVException e) {
//            e.printStackTrace();
//        }
//
//        task.setTime(time);
//        task.setAnswers(answers);
//
//        return task;
//    }
//
//    // TODO same the above, each type of data should have their own class,
//    // and implement the same objectToInstance interface
//
//    public static MessageContent.Message objectToMessage(AVObject messageObject) {
//        MessageContent.Message message = new MessageContent.Message();
//
//        message.setObjectId(messageObject.getObjectId());
//        message.setTitle(messageObject.getString(MessageContent.TITLE));
//        message.setOrder(messageObject.getInt(MessageContent.ORDER));
//        message.setOptions(messageObject.getJSONObject(MessageContent.OPTIONS));
//
//        return message;
//    }
//
//    public static Answer objectToAnswer(AVObject answerObject) {
//        Answer answer = new Answer();
//        try {
//            answerObject = answerObject.fetchIfNeeded();
//            answer.setObjectId(answerObject.getObjectId());
//
//            answer.setSender((AVUser) answerObject.getAVUser(Answer.SENDER).fetchIfNeeded());
//            answer.setReceiver((AVUser) answerObject.getAVUser(Answer.RECEIVER).fetchIfNeeded());
//            answer.setOptions(answerObject.getString(Answer.ANSWER_OPTION_KEY));
//            answer.setTime(answerObject.getCreatedAt().toString());
//        } catch (AVException e) {
//            e.printStackTrace();
//        }
//
//        return answer;
//    }


}