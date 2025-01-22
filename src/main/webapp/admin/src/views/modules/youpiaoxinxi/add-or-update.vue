<template>
  <div class="addEdit-block">
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
	  :style="{backgroundColor:addEditForm.addEditBoxColor}"
    >
      <el-row >
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="邮票名称" prop="youpiaomingcheng">
          <el-input v-model="ruleForm.youpiaomingcheng" 
              placeholder="邮票名称" clearable  :readonly="ro.youpiaomingcheng"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="邮票名称" prop="youpiaomingcheng">
              <el-input v-model="ruleForm.youpiaomingcheng" 
                placeholder="邮票名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="24">  
        <el-form-item class="upload" v-if="type!='info' && !ro.youpiaofengmian" label="邮票封面" prop="youpiaofengmian">
          <file-upload
          tip="点击上传邮票封面"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.youpiaofengmian?ruleForm.youpiaofengmian:''"
          @change="youpiaofengmianUploadChange"
          ></file-upload>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.youpiaofengmian" label="邮票封面" prop="youpiaofengmian">
            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.youpiaofengmian.split(',')" :src="$base.url+item" width="100" height="100">
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="select" v-if="type!='info'"  label="邮票分类" prop="youpiaofenlei">
          <el-select :disabled="ro.youpiaofenlei" v-model="ruleForm.youpiaofenlei" placeholder="请选择邮票分类">
            <el-option
                v-for="(item,index) in youpiaofenleiOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="邮票分类" prop="youpiaofenlei">
	      <el-input v-model="ruleForm.youpiaofenlei"
                placeholder="邮票分类" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="作者" prop="zuozhe">
          <el-input v-model="ruleForm.zuozhe" 
              placeholder="作者" clearable  :readonly="ro.zuozhe"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="作者" prop="zuozhe">
              <el-input v-model="ruleForm.zuozhe" 
                placeholder="作者" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="date" v-if="type!='info'" label="发布年限" prop="fabunianxian">
            <el-date-picker
                format="yyyy 年 MM 月 dd 日"
                value-format="yyyy-MM-dd"
                v-model="ruleForm.fabunianxian" 
                type="date"
                :readonly="ro.fabunianxian"
                placeholder="发布年限">
            </el-date-picker> 
        </el-form-item>
        <div v-else>
          <el-form-item class="input" v-if="ruleForm.fabunianxian" label="发布年限" prop="fabunianxian">
              <el-input v-model="ruleForm.fabunianxian" 
                placeholder="发布年限" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="材质" prop="caizhi">
          <el-input v-model="ruleForm.caizhi" 
              placeholder="材质" clearable  :readonly="ro.caizhi"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="材质" prop="caizhi">
              <el-input v-model="ruleForm.caizhi" 
                placeholder="材质" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="尺寸" prop="chicun">
          <el-input v-model="ruleForm.chicun" 
              placeholder="尺寸" clearable  :readonly="ro.chicun"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="尺寸" prop="chicun">
              <el-input v-model="ruleForm.chicun" 
                placeholder="尺寸" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="面值" prop="mianzhi">
          <el-input v-model="ruleForm.mianzhi" 
              placeholder="面值" clearable  :readonly="ro.mianzhi"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="面值" prop="mianzhi">
              <el-input v-model="ruleForm.mianzhi" 
                placeholder="面值" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="印刷单位" prop="yinshuadanwei">
          <el-input v-model="ruleForm.yinshuadanwei" 
              placeholder="印刷单位" clearable  :readonly="ro.yinshuadanwei"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="印刷单位" prop="yinshuadanwei">
              <el-input v-model="ruleForm.yinshuadanwei" 
                placeholder="印刷单位" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item v-if="type!='info'"  label="邮票详情" prop="youpiaoxiangqing">
                <editor 
                    style="min-width: 200px; max-width: 600px;"
                    v-model="ruleForm.youpiaoxiangqing" 
                    class="editor" 
                    action="file/upload">
                </editor>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.youpiaoxiangqing" label="邮票详情" prop="youpiaoxiangqing">
                    <span v-html="ruleForm.youpiaoxiangqing"></span>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
      <el-form-item class="btn">
        <el-button  v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
        <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
        <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
  data() {
    let self = this
    var validateIdCard = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!checkIdCard(value)) {
        callback(new Error("请输入正确的身份证号码"));
      } else {
        callback();
      }
    };
    var validateUrl = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isURL(value)) {
        callback(new Error("请输入正确的URL地址"));
      } else {
        callback();
      }
    };
    var validateMobile = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isMobile(value)) {
        callback(new Error("请输入正确的手机号码"));
      } else {
        callback();
      }
    };
    var validatePhone = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isPhone(value)) {
        callback(new Error("请输入正确的电话号码"));
      } else {
        callback();
      }
    };
    var validateEmail = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isEmail(value)) {
        callback(new Error("请输入正确的邮箱地址"));
      } else {
        callback();
      }
    };
    var validateNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isNumber(value)) {
        callback(new Error("请输入数字"));
      } else {
        callback();
      }
    };
    var validateIntNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isIntNumer(value)) {
        callback(new Error("请输入整数"));
      } else {
        callback();
      }
    };
    return {
	  addEditForm: {"btnSaveFontColor":"#fff","selectFontSize":"14px","btnCancelBorderColor":"rgba(45, 132, 94, 1)","inputBorderRadius":"30px","inputFontSize":"14px","textareaBgColor":"#fff","btnSaveFontSize":"14px","textareaBorderRadius":"30px","uploadBgColor":"#fff","textareaBorderStyle":"solid","btnCancelWidth":"88px","textareaHeight":"120px","dateBgColor":"#fff","btnSaveBorderRadius":"4px","uploadLableFontSize":"14px","textareaBorderWidth":"2px","inputLableColor":"#606266","addEditBoxColor":"rgba(255, 255, 255, 1)","dateIconFontSize":"14px","btnSaveBgColor":"rgba(45, 132, 94, 1)","uploadIconFontColor":"rgba(45, 132, 94, 1)","textareaBorderColor":"rgba(45, 132, 94, 1)","btnCancelBgColor":"rgba(255, 255, 255, 1)","selectLableColor":"#606266","btnSaveBorderStyle":"double","dateBorderWidth":"2px","dateLableFontSize":"14px","dateBorderRadius":"30px","btnCancelBorderStyle":"double","selectLableFontSize":"14px","selectBorderStyle":"solid","selectIconFontColor":"rgba(45, 132, 94, 1)","btnCancelHeight":"44px","inputHeight":"40px","btnCancelFontColor":"rgba(45, 132, 94, 1)","dateBorderColor":"rgba(45, 132, 94, 1)","dateIconFontColor":"rgba(45, 132, 94, 1)","uploadBorderStyle":"solid","dateBorderStyle":"solid","dateLableColor":"#606266","dateFontSize":"14px","inputBorderWidth":"2px","uploadIconFontSize":"28px","selectHeight":"40px","inputFontColor":"#606266","uploadHeight":"148px","textareaLableColor":"#606266","textareaLableFontSize":"14px","btnCancelFontSize":"14px","inputBorderStyle":"solid","btnCancelBorderRadius":"4px","inputBgColor":"#fff","inputLableFontSize":"14px","uploadLableColor":"#606266","uploadBorderRadius":"30px","btnSaveHeight":"44px","selectBgColor":"#fff","btnSaveWidth":"88px","selectIconFontSize":"14px","dateHeight":"40px","selectBorderColor":"rgba(45, 132, 94, 1)","inputBorderColor":"rgba(45, 132, 94, 1)","uploadBorderColor":"rgba(45, 132, 94, 1)","textareaFontColor":"#606266","selectBorderWidth":"2px","dateFontColor":"#606266","btnCancelBorderWidth":"4px","uploadBorderWidth":"2px","textareaFontSize":"14px","selectBorderRadius":"30px","selectFontColor":"#606266","btnSaveBorderColor":"rgba(255, 255, 255, 1)","btnSaveBorderWidth":"4px"},
      id: '',
      type: '',
      ro:{
	youpiaomingcheng : false,
	youpiaofengmian : false,
	youpiaofenlei : false,
	zuozhe : false,
	fabunianxian : false,
	caizhi : false,
	chicun : false,
	mianzhi : false,
	yinshuadanwei : false,
	youpiaoxiangqing : false,
	clicktime : false,
      },
      ruleForm: {
        youpiaomingcheng: '',
        youpiaofengmian: '',
        youpiaofenlei: '',
        zuozhe: '',
        fabunianxian: '',
        caizhi: '',
        chicun: '',
        mianzhi: '',
        yinshuadanwei: '',
        youpiaoxiangqing: '',
        clicktime: '',
      },
          youpiaofenleiOptions: [],
      rules: {
          youpiaomingcheng: [
                { required: true, message: '邮票名称不能为空', trigger: 'blur' },
          ],
          youpiaofengmian: [
          ],
          youpiaofenlei: [
                { required: true, message: '邮票分类不能为空', trigger: 'blur' },
          ],
          zuozhe: [
                { required: true, message: '作者不能为空', trigger: 'blur' },
          ],
          fabunianxian: [
          ],
          caizhi: [
          ],
          chicun: [
          ],
          mianzhi: [
          ],
          yinshuadanwei: [
                { required: true, message: '印刷单位不能为空', trigger: 'blur' },
          ],
          youpiaoxiangqing: [
          ],
          clicktime: [
          ],
      }
    };
  },
  props: ["parent"],
  computed: {



  },
  created() {
	this.addEditStyleChange()
	this.addEditUploadStyleChange()
  },
  methods: {
    // 下载
    download(file){
      window.open(`${file}`)
    },
    // 初始化
    init(id,type) {
      if (id) {
        this.id = id;
        this.type = type;
      }
      if(this.type=='info'||this.type=='else'){
        this.info(id);
      }else if(this.type=='logistics'){
        this.logistics=false;
        this.info(id);
      }else if(this.type=='cross'){
        var obj = this.$storage.getObj('crossObj');
        for (var o in obj){
          if(o=='youpiaomingcheng'){
            this.ruleForm.youpiaomingcheng = obj[o];
	    this.ro.youpiaomingcheng = true;
            continue;
          }
          if(o=='youpiaofengmian'){
            this.ruleForm.youpiaofengmian = obj[o];
	    this.ro.youpiaofengmian = true;
            continue;
          }
          if(o=='youpiaofenlei'){
            this.ruleForm.youpiaofenlei = obj[o];
	    this.ro.youpiaofenlei = true;
            continue;
          }
          if(o=='zuozhe'){
            this.ruleForm.zuozhe = obj[o];
	    this.ro.zuozhe = true;
            continue;
          }
          if(o=='fabunianxian'){
            this.ruleForm.fabunianxian = obj[o];
	    this.ro.fabunianxian = true;
            continue;
          }
          if(o=='caizhi'){
            this.ruleForm.caizhi = obj[o];
	    this.ro.caizhi = true;
            continue;
          }
          if(o=='chicun'){
            this.ruleForm.chicun = obj[o];
	    this.ro.chicun = true;
            continue;
          }
          if(o=='mianzhi'){
            this.ruleForm.mianzhi = obj[o];
	    this.ro.mianzhi = true;
            continue;
          }
          if(o=='yinshuadanwei'){
            this.ruleForm.yinshuadanwei = obj[o];
	    this.ro.yinshuadanwei = true;
            continue;
          }
          if(o=='youpiaoxiangqing'){
            this.ruleForm.youpiaoxiangqing = obj[o];
	    this.ro.youpiaoxiangqing = true;
            continue;
          }
          if(o=='clicktime'){
            this.ruleForm.clicktime = obj[o];
	    this.ro.clicktime = true;
            continue;
          }
        }
      }
      // 获取用户信息
      this.$http({
        url: `${this.$storage.get('sessionTable')}/session`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          var json = data.data;
        } else {
          this.$message.error(data.msg);
        }
      });
            this.$http({
              url: `option/youpiaofenlei/youpiaofenlei`,
              method: "get"
            }).then(({ data }) => {
              if (data && data.code === 0) {
                this.youpiaofenleiOptions = data.data;
              } else {
                this.$message.error(data.msg);
              }
            });
         
    },
    // 多级联动参数
    info(id) {
      this.$http({
        url: `youpiaoxinxi/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
	//解决前台上传图片后台不显示的问题
	let reg=new RegExp('../../../upload','g')//g代表全部
	this.ruleForm.youpiaoxiangqing = this.ruleForm.youpiaoxiangqing.replace(reg,'../../../ssm34f5g/upload');
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {




	if(this.ruleForm.youpiaofengmian!=null) {
		this.ruleForm.youpiaofengmian = this.ruleForm.youpiaofengmian.replace(new RegExp(this.$base.url,"g"),"");
	}



















var objcross = this.$storage.getObj('crossObj');

      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(!statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
       this.$refs["ruleForm"].validate(valid => {
         if (valid) {
		 if(crossrefid && crossuserid) {
			 this.ruleForm.crossuserid = crossuserid;
			 this.ruleForm.crossrefid = crossrefid;
			let params = { 
				page: 1, 
				limit: 10, 
				crossuserid:this.ruleForm.crossuserid,
				crossrefid:this.ruleForm.crossrefid,
			} 
			this.$http({ 
				url: "youpiaoxinxi/page", 
				method: "get", 
				params: params 
			}).then(({ 
				data 
			}) => { 
				if (data && data.code === 0) { 
				       if(data.data.total>=crossoptnum) {
					     this.$message.error(this.$storage.get('tips'));
					       return false;
				       } else {
					 this.$http({
					   url: `youpiaoxinxi/${!this.ruleForm.id ? "save" : "update"}`,
					   method: "post",
					   data: this.ruleForm
					 }).then(({ data }) => {
					   if (data && data.code === 0) {
					     this.$message({
					       message: "操作成功",
					       type: "success",
					       duration: 1500,
					       onClose: () => {
						 this.parent.showFlag = true;
						 this.parent.addOrUpdateFlag = false;
						 this.parent.youpiaoxinxiCrossAddOrUpdateFlag = false;
						 this.parent.search();
						 this.parent.contentStyleChange();
					       }
					     });
					   } else {
					     this.$message.error(data.msg);
					   }
					 });

				       }
				} else { 
				} 
			});
		 } else {
			 this.$http({
			   url: `youpiaoxinxi/${!this.ruleForm.id ? "save" : "update"}`,
			   method: "post",
			   data: this.ruleForm
			 }).then(({ data }) => {
			   if (data && data.code === 0) {
			     this.$message({
			       message: "操作成功",
			       type: "success",
			       duration: 1500,
			       onClose: () => {
				 this.parent.showFlag = true;
				 this.parent.addOrUpdateFlag = false;
				 this.parent.youpiaoxinxiCrossAddOrUpdateFlag = false;
				 this.parent.search();
				 this.parent.contentStyleChange();
			       }
			     });
			   } else {
			     this.$message.error(data.msg);
			   }
			 });
		 }
         }
       });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.youpiaoxinxiCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    youpiaofengmianUploadChange(fileUrls) {
	this.ruleForm.youpiaofengmian = fileUrls;
	this.addEditUploadStyleChange()
    },
	addEditStyleChange() {
	  this.$nextTick(()=>{
	    // input
	    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputFontColor
	      el.style.fontSize = this.addEditForm.inputFontSize
	      el.style.borderWidth = this.addEditForm.inputBorderWidth
	      el.style.borderStyle = this.addEditForm.inputBorderStyle
	      el.style.borderColor = this.addEditForm.inputBorderColor
	      el.style.borderRadius = this.addEditForm.inputBorderRadius
	      el.style.backgroundColor = this.addEditForm.inputBgColor
	    })
	    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputLableColor
	      el.style.fontSize = this.addEditForm.inputLableFontSize
	    })
	    // select
	    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectFontColor
	      el.style.fontSize = this.addEditForm.selectFontSize
	      el.style.borderWidth = this.addEditForm.selectBorderWidth
	      el.style.borderStyle = this.addEditForm.selectBorderStyle
	      el.style.borderColor = this.addEditForm.selectBorderColor
	      el.style.borderRadius = this.addEditForm.selectBorderRadius
	      el.style.backgroundColor = this.addEditForm.selectBgColor
	    })
	    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectLableColor
	      el.style.fontSize = this.addEditForm.selectLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
	      el.style.color = this.addEditForm.selectIconFontColor
	      el.style.fontSize = this.addEditForm.selectIconFontSize
	    })
	    // date
	    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateFontColor
	      el.style.fontSize = this.addEditForm.dateFontSize
	      el.style.borderWidth = this.addEditForm.dateBorderWidth
	      el.style.borderStyle = this.addEditForm.dateBorderStyle
	      el.style.borderColor = this.addEditForm.dateBorderColor
	      el.style.borderRadius = this.addEditForm.dateBorderRadius
	      el.style.backgroundColor = this.addEditForm.dateBgColor
	    })
	    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateLableColor
	      el.style.fontSize = this.addEditForm.dateLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
	      el.style.color = this.addEditForm.dateIconFontColor
	      el.style.fontSize = this.addEditForm.dateIconFontSize
	      el.style.lineHeight = this.addEditForm.dateHeight
	    })
	    // upload
	    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
	    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
	      el.style.width = this.addEditForm.uploadHeight
	      el.style.height = this.addEditForm.uploadHeight
	      el.style.borderWidth = this.addEditForm.uploadBorderWidth
	      el.style.borderStyle = this.addEditForm.uploadBorderStyle
	      el.style.borderColor = this.addEditForm.uploadBorderColor
	      el.style.borderRadius = this.addEditForm.uploadBorderRadius
	      el.style.backgroundColor = this.addEditForm.uploadBgColor
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.uploadHeight
	      el.style.color = this.addEditForm.uploadLableColor
	      el.style.fontSize = this.addEditForm.uploadLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
	      el.style.color = this.addEditForm.uploadIconFontColor
	      el.style.fontSize = this.addEditForm.uploadIconFontSize
	      el.style.lineHeight = iconLineHeight
	      el.style.display = 'block'
	    })
	    // 多文本输入框
	    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
	      el.style.height = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaFontColor
	      el.style.fontSize = this.addEditForm.textareaFontSize
	      el.style.borderWidth = this.addEditForm.textareaBorderWidth
	      el.style.borderStyle = this.addEditForm.textareaBorderStyle
	      el.style.borderColor = this.addEditForm.textareaBorderColor
	      el.style.borderRadius = this.addEditForm.textareaBorderRadius
	      el.style.backgroundColor = this.addEditForm.textareaBgColor
	    })
	    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
	      // el.style.lineHeight = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaLableColor
	      el.style.fontSize = this.addEditForm.textareaLableFontSize
	    })
	    // 保存
	    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
	      el.style.width = this.addEditForm.btnSaveWidth
	      el.style.height = this.addEditForm.btnSaveHeight
	      el.style.color = this.addEditForm.btnSaveFontColor
	      el.style.fontSize = this.addEditForm.btnSaveFontSize
	      el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
	      el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
	      el.style.borderColor = this.addEditForm.btnSaveBorderColor
	      el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnSaveBgColor
	    })
	    // 返回
	    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
	      el.style.width = this.addEditForm.btnCancelWidth
	      el.style.height = this.addEditForm.btnCancelHeight
	      el.style.color = this.addEditForm.btnCancelFontColor
	      el.style.fontSize = this.addEditForm.btnCancelFontSize
	      el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
	      el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
	      el.style.borderColor = this.addEditForm.btnCancelBorderColor
	      el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnCancelBgColor
	    })
	  })
	},
	addEditUploadStyleChange() {
		this.$nextTick(()=>{
		  document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
			el.style.width = this.addEditForm.uploadHeight
			el.style.height = this.addEditForm.uploadHeight
			el.style.borderWidth = this.addEditForm.uploadBorderWidth
			el.style.borderStyle = this.addEditForm.uploadBorderStyle
			el.style.borderColor = this.addEditForm.uploadBorderColor
			el.style.borderRadius = this.addEditForm.uploadBorderRadius
			el.style.backgroundColor = this.addEditForm.uploadBgColor
		  })
	  })
	},
  }
};
</script>
<style lang="scss">
.editor{
  height: 500px;
  
  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
	background-color: transparent;
}
.btn .el-button {
  padding: 0;
}
</style>
