//package com.example.marvin.familylink._UI.activity;
//
//
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.os.Handler;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.support.v4.widget.SwipeRefreshLayout;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import com.avos.avoscloud.AVUser;
//import com.example.marvin.familylink.R;
//import com.example.marvin.familylink._UI._Utils.BLog;
//import com.example.marvin.familylink._UI._Utils.Constants;
//import com.example.marvin.familylink._UI._Utils.Utils;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//
///**
// * Created by mawenjing on 15/5/18.
// */
//public class FamilyFragment extends Fragment {
//    private static Context context;
//
//    public FamilyFragment() {
//    }
//
//    public static Fragment newInstance() {
//        FamilyFragment familyFragment = new FamilyFragment();
//        return familyFragment;
//    }
//
//    private boolean isFirstLogin = false;
//
//    // CardType Constants
//    private final static int CARDTYPE_NUM = 2;
//    private final static int CARDTYPE_1 = 0;
//    private final static int CARDTYPE_2 = 1;
//
//
//    // Fetch file cache and show
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        if (BLog.logEnable == true) {
//            BLog.d("### Task Fragment onCreateView");
//        }
//
//        View view = inflater.inflate(R.layout.fragment_task, null);
//
//        context = getActivity();
//
//        return view;
//    }
//
//    // Do some refresh work
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//
//        if (BLog.logEnable == true) {
//            BLog.d("###Task Fragment On Resume");
//        }
//
//        isFirstLogin = Constants.SP.getBoolean(Constants.USER_FIRST_LOGIN, false);
//
//        try {
//            fileCache = FileCache.getFileCache(context);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        unrepliedTasks = fileCache.readTaskObject(Constants.UNREPLIED_TASK_MEMORY_KEY);
//        sentTasks = fileCache.readTaskObject(Constants.SENT_TASK_MEMORY_KEY);
//        setCardsView();
//
//        refresh();
//        setSwipeLayoutRefresh(true);
//    }
//
//    private List<Card> initQuestionCard(List<Task> tasks) {
//        List<Card> questionCards = new ArrayList<Card>();
//        if (tasks != null) {
//            for (int i = 0; i < tasks.size(); i++) {
//                final Task task = tasks.get(i);
//
//                JSONObject options = task.msg.getOptions();
//                String sPositive = null, sNegative = null;
//
//                try {
//                    sPositive = options.getString(MessageContent.POSITIVE);
//                    sNegative = options.getString(MessageContent.NEGATIVE);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                View answerView = inflater.inflate(R.layout.questioncard_button_action, null);
//                TextView btn_positive  = (TextView) answerView.findViewById(R.id.positive_button);
//                btn_positive.setText(sPositive);
//                TextView btn_negative = (TextView) answerView.findViewById(R.id.negative_button);
//                btn_negative.setText(sNegative);
//
//                ArrayList<BaseSupplementalAction> actions = new ArrayList<BaseSupplementalAction>();
//
//                // Set supplemental actions
//                TextSupplementalAction positive = new TextSupplementalAction(context, R.id.positive_button);
//                positive.setOnActionClickListener(new BaseSupplementalAction.OnActionClickListener() {
//                    @Override
//                    public void onClick(Card card, View view) {
//                        onButtonClick(task.getObjectId(), card, MessageContent.POSITIVE);
//                    }
//                });
//                actions.add(positive);
//
//                TextSupplementalAction negative = new TextSupplementalAction(context, R.id.negative_button);
//                negative.setOnActionClickListener(new BaseSupplementalAction.OnActionClickListener() {
//                    @Override
//                    public void onClick(Card card, View view) {
//                        onButtonClick(task.getObjectId(), card, MessageContent.NEGATIVE);
//                    }
//                });
//                actions.add(negative);
//
//                String userId = task.sender.getObjectId();
//                Bitmap bitmap = Utils.imageCache.get(userId);
//
//                if (bitmap == null) {
//                    bitmap = fileCache.getUserPhoto(userId);
//                }
//
//                UnrepliedTaskCard card =
//                        UnrepliedTaskCard.with(context)
//                                .setMainTitle(task.getSender().getUsername())
//                                .setSculpture(bitmap)
//                                .setSubTitle(task.msg.title)
//                                .setCreateTime(task.getTime())
//                                .setupSupplementalActions(R.layout.questioncard_button_action, actions)
//                                .build();
//                card.setType(CARDTYPE_1);
//
//                questionCards.add(card);
//            }
//        }
//
//        return questionCards;
//    }
//
//    private void onButtonClick(String taskId, Card card, String btnType) {
//        MessageUtils.completeTask(taskId, btnType);
//
//        dismissAnimation.animateDismiss(card);
//
//    }
//
//    private List<Card> initTaskCard(List<Task> tasks) {
//        List<Card> taskCards = new ArrayList<Card>();
//        if (tasks != null) {
//            for (int i = 0; i < tasks.size(); i++) {
//                Task task = tasks.get(i);
//
//                SentTaskCard taskCard = new SentTaskCard(context);
//                taskCard.setmCreateTime(task.time);
//                taskCard.setmMessage(task.msg.title);
//                taskCard.setmTasks(getTaskAnswers(task));
//                taskCard.setType(CARDTYPE_2);
//                taskCards.add(taskCard);
//            }
//        }
//        return taskCards;
//    }
//
//    private String[] getTaskAnswers (Task task) {
//        String notRespond = " has not responded";
//
//        List<Answer> answers = task.getAnswers();
//        List<AVUser> receivers = task.getReceivers();
//        MessageContent.Message msg = task.getMsg();
//
//        String[] taskAnswers = new String[receivers.size()];
//
//        Map<String, String> answerList = new HashMap<String, String>();
//        for (int i = 0; i < receivers.size(); i++) {
//            answerList.put(receivers.get(i).getUsername(), notRespond);
//        }
//
//        for (int i = 0; i < answers.size(); i++) {
//            try {
//                answerList.put(answers.get(i).getSender().getUsername(), " answered " + msg.getOptions().getString(answers.get(i).getOptions()));
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//
//        Iterator iterator = answerList.entrySet().iterator();
//        int count = 0;
//        while (iterator.hasNext()) {
//            Map.Entry entry = (Map.Entry) iterator.next();
//
//            String answerString = "";
//            answerString += (String) entry.getKey();
//            answerString += (String) entry.getValue();
//            taskAnswers[count] = answerString;
//            count ++;
//        }
//
//        return taskAnswers;
//    }
//
//    // Fragment Refresh
//    @Override
//    public void onRefresh() {
//        final Handler mHandler = new Handler();
//        mHandler.post(new Runnable() {
//            @Override
//            public void run() {
//                refresh();
//            }
//        });
//    }
//
//    // set the action that swipe layout doing right now
//    private void setSwipeLayoutRefresh(boolean value) {
//        if (value == true) {
//            refreshLayout.post(new Runnable() {
//                @Override
//                public void run() {
//                    refreshLayout.setRefreshing(true);
//                }
//            });
//        } else {
//            refreshLayout.post(new Runnable() {
//                @Override
//                public void run() {
//                    refreshLayout.setRefreshing(false);
//                }
//            });
//        }
//    }
//
//    class GetCardTask extends AsyncTask<Void, Void, Void> {
//        @Override
//        protected Void doInBackground(Void... params) {
//            unrepliedTasks = MessageUtils.getUnrepliedTasks();
//            sentTasks = MessageUtils.getSentTasks();
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
//            setCardsView();
//            setSwipeLayoutRefresh(false);
//
//            fileCache.saveTaskObject(Constants.UNREPLIED_TASK_MEMORY_KEY, unrepliedTasks);
//            fileCache.saveTaskObject(Constants.SENT_TASK_MEMORY_KEY, sentTasks);
//
//            Constants.EDITOR.putBoolean(Constants.USER_FIRST_LOGIN, false);
//            Constants.EDITOR.commit();
//        }
//    }
//
//    public void setCardsView() {
//        allCards.clear();
//
//        if (unrepliedTasks != null && context != null) {
//            unrepliedCards = initQuestionCard(unrepliedTasks);
//            allCards.addAll(unrepliedCards);
//        }
//        if (sentTasks != null && context != null) {
//            sentCards = initTaskCard(sentTasks);
//            allCards.addAll(sentCards);
//        }
//
//        if (allCards.size() != 0 && allCards != null && context != null) {
//            cardArrayAdapter.notifyDataSetChanged();
//            cardArrayAdapter.setInnerViewTypeCount(CARDTYPE_NUM);
//            dismissAnimation = (SwipeDismissAnimation) new SwipeDismissAnimation(context).
//                    setup(cardArrayAdapter);
//            cardList.setAdapter(cardArrayAdapter);
//        }
//    }
//
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        EventBus.getDefault().register(this);
//    }
//
//    @Override
//    public void onStop() {
//        EventBus.getDefault().unregister(this);
//        super.onStop();
//    }
//
//
//    public void onEvent(RefreshTaskEvent event) {
//        refresh();
//    }
//
//    private void refresh() {
//        if (Utils.isNetworkAvailable(context) == true) {
//            new GetCardTask().execute();
//        } else {
//            Utils.showConnectionNADialog(context);
//        }
//    }
//
//
//}
