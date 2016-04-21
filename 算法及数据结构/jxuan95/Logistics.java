//package jxuan95;
//
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//import java.util.UUID;
//
///**
// * Created by jxuan on 16-4-20.
// */
//public class Logistics {
//
//    /**
//     * 访问addGoodsDetail接口向数据库插入一个商品
//     *
//     * @param request 传入商品的id，传入物流详情
//     * @param id      id
//     */
//    @RequestMapping("/addGoodsDetail")
//    public static void insertGoods(HttpServletRequest request, HttpServerSession session,
//                                   @RequestParam(value = "uuid") UUID id, @RequestParam("content") string content) {
//        goods g = new goods(id, content);
//        Date time = new Date();//记录插入物流详情的时间
//
//        int result = mapper.update(g);//向数据库中更新商品记录，用一个链表存放商品的物流更新列表
//
//    }
//
//    /**
//     * 从数据库获取货物的评论列表即
//     *
//     * @param id 传入该商品的id
//     */
//    public static getGoodsContentList(@PathVariable("id") int id) {
//        int[] contentList = mapper.selectGoodsContetnList(id);//获取该货物的评论列表
//
//        int[] result = mergeSort(contentList);//通过归并排序将时间最小的也是最新的信息排在最前面
//
//        List<content> contetnList = mapper.selectGoodsByTimeSort(result);//传入时间排序结果，获取每个时间对应的content
//
//        //剔除内容重复的物流信息
//        for (int i = 0; i < contentList.length; i++) {
//            String temp = contentList[i].getDetail();
//            for (int j = 1; j < contentList.length; j++) {
//                if (contentList[j].getDetail().equals(temp)) {
//                    contentList[j].remove();//删除该重复记录
//                }
//            }
//        }
//
//        //达成需求
//
//    }
//
//
//    public static int[] mergeSort(int[] arr) {
//        int[] temp = new int[arr.length];
//        internalMergeSort(arr, temp, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));
//        return arr;
//    }
//
//    private static void internalMergeSort(int[] a, int[] b, int left, int right) {
//        //当left==right的时，已经不需要再划分了
//        if (left < right) {
//            int middle = (left + right) / 2;
//            internalMergeSort(a, b, left, middle);          //左子数组
//            internalMergeSort(a, b, middle + 1, right);       //右子数组
//            mergeSortedArray(a, b, left, middle, right);    //合并两个子数组
//        }
//    }
//
//    // 合并两个有序子序列 arr[left, ..., middle] 和 arr[middle+1, ..., right]。temp是辅助数组。
//    private static void mergeSortedArray(int arr[], int temp[], int left, int middle, int right) {
//        int i = left;
//        int j = middle + 1;
//        int k = 0;
//
//        while (i <= middle && j <= right) {
//            if (arr[i] <= arr[j]) {
//                temp[k++] = arr[i++];
//            } else {
//                temp[k++] = arr[j++];
//            }
//        }
//
//        while (i <= middle) {
//            temp[k++] = arr[i++];
//        }
//        while (j <= right) {
//            temp[k++] = arr[j++];
//        }
//
//        for (i = 0; i < k; i++) {
//            arr[left + i] = temp[i];
//        }
//    }
//
//    class goods {
//        private int id;//每个货物的ID
//        private String content;//每个货物的物流情况
//
//        public goods(int id, String content) {
//            this.id = id;
//            this.content = content;
//        }
//
//        public int getId() {
//            return id;
//        }
//
//        public void setId(int id) {
//            this.id = id;
//        }
//
//        public String getContent() {
//            return content;
//        }
//
//        public void setContent(String content) {
//            this.content = content;
//        }
//
//        @Override
//        public String toString() {
//            return "goods{" +
//                    "id=" + id +
//                    ", content='" + content + '\'' +
//                    '}';
//        }
//    }
//
//    class content {
//        private Date date;//物流情况创建时间
//        private String detail;//详细内容
//        private String id;//物流id
//
//        public content(Date date, String detail, String id) {
//            this.date = date;
//            this.detail = detail;
//            this.id = id;
//        }
//
//        public Date getDate() {
//            return date;
//        }
//
//        public void setDate(Date date) {
//            this.date = date;
//        }
//
//        public String getDetail() {
//            return detail;
//        }
//
//        public void setDetail(String detail) {
//            this.detail = detail;
//        }
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        @Override
//        public String toString() {
//            return "content{" +
//                    "date=" + date +
//                    ", detail='" + detail + '\'' +
//                    ", id='" + id + '\'' +
//                    '}';
//        }
//    }
//}
