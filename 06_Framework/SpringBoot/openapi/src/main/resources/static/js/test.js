const serviceKey = "VcbepY4cNJk%2BDnhTIbR0c71kDzGFYSHoaFX5VRegchN6WSqrekGX0glGXtixCpKdbF8VOEmzFhfwhgeIKG62%2Bg%3D%3D";

const getAirPollution = (sidoName) => {

const requestUrl = 'http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty';

// 쿼리 스트링 생성 (URLSearchParams.toString())

const searchParams = new URLSearchParams();
searchParams.append('serviceKey', serviceKey);
searchParams.append('returnType', 'JSON');

searchParams.append('sidoName', sidoName);

fetch(`${requestUrl}?${searchParams.toString()}`)

.then(resp => resp.json())

.then(result => {

console.log(result);

})

.catch(e => console.log(e));

}