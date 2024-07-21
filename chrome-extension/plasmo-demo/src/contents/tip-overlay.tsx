import cssText from 'data-text:~/css/tip.scss';
import type {
	PlasmoCSConfig, PlasmoGetOverlayAnchor,
	PlasmoWatchOverlayAnchor
} from 'plasmo';

// 直接向网页注入的css
import '../css/injectCss.scss';


//overlay的方式主要是 直接设置坐标来弄的


export const config: PlasmoCSConfig = {
	matches: ['https://www.baidu.com/*']
};

//获取坐标位置
export const getOverlayAnchor: PlasmoGetOverlayAnchor = async () => (
	document.querySelector('.s_btn_wr')
);

//坐标更新 由于是通过坐标锚定设置的位置  当目标坐标发生改变  自身并不会有变化         ，  注意 0.88版本后好像不需要这一个东西了
export const watchOverlayAnchor: PlasmoWatchOverlayAnchor = (
  updatePosition
) => {
  const interval = setInterval(() => {
    updatePosition()
  }, 200);
  
  return () => {
    clearInterval(interval);
  };
};

export const getStyle = () => {
  const style = document.createElement('style');
  style.textContent = cssText;
  return style;
};


export const getShadowHostId = () => 'plasmo-tip-ip';

const Tip = () => {
  return (
    <div id='tip'>
			tip
    </div>
  );
};

export default Tip;
