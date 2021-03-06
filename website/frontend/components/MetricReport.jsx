import React from 'react';
import MetricCard from './MetricCard';

export default class MetricReport extends React.Component {
  constructor() {
    super();
  }

  render() {
    let metricReport = this.props.data.metricReport;

    metricReport.lineOfCode.score = metricReport.lineOfCode.score.toFixed(2);
    metricReport.depthOfConditionalNesting.score =
        metricReport.depthOfConditionalNesting.score.toFixed(2);
    metricReport.lengthOfIdentifier.score = metricReport.lengthOfIdentifier.score.toFixed(2);
    metricReport.numberOfMethod.score = metricReport.numberOfMethod.score.toFixed(2);
    metricReport.numberOfAttribute.score = metricReport.numberOfAttribute.score.toFixed(2);

    metricReport.overallData.percentage = metricReport.overallData.percentage.toFixed(2);
    metricReport.analysabilityData.percentage =
        metricReport.analysabilityData.percentage.toFixed(2);
    metricReport.testabilityData.percentage = metricReport.testabilityData.percentage.toFixed(2);

    return  <div>
              <div className='row'>
                <div className='col-md-3'>
                  <MetricCard data={metricReport.overallData}/>
                </div>
                <div className='col-md-3'>
                  <MetricCard data={metricReport.analysabilityData}/>
                </div>
                <div className='col-md-3'>
                  <MetricCard data={metricReport.testabilityData}/>
                </div>
              </div>

              <table className='table table-striped table-hover'>
                <thead>
                  <tr>
                    <th>Metric</th>
                    <th>Your value</th>
                    <th>Benchmark value</th>
                    <th>Score</th>
                  </tr>
                </thead>
                <tbody>
                  <tr className={metricReport.lineOfCode.score < 80 ? 'danger' : ''}>
                    <td>Line of codes</td>
                    <td>{metricReport.lineOfCode.value}</td>
                    <td>{metricReport.lineOfCode.benchmark}</td>
                    <td>{metricReport.lineOfCode.score}%</td>
                  </tr>
                  <tr className={metricReport.depthOfConditionalNesting.score < 80 ? 'danger' : ''}>
                    <td>Depth of conditional nesting</td>
                    <td>{metricReport.depthOfConditionalNesting.value}</td>
                    <td>{metricReport.depthOfConditionalNesting.benchmark}</td>
                    <td>{metricReport.depthOfConditionalNesting.score}%</td>
                  </tr>
                  <tr className={metricReport.lengthOfIdentifier.score < 80 ? 'danger' : ''}>
                    <td>Average length of identifier</td>
                    <td>{metricReport.lengthOfIdentifier.value}</td>
                    <td>{metricReport.lengthOfIdentifier.benchmark}</td>
                    <td>{metricReport.lengthOfIdentifier.score}%</td>
                  </tr>
                  <tr className={metricReport.numberOfMethod.score < 80 ? 'danger' : ''}>
                    <td>Number of methods</td>
                    <td>{metricReport.numberOfMethod.value}</td>
                    <td>{metricReport.numberOfMethod.benchmark}</td>
                    <td>{metricReport.numberOfMethod.score}%</td>
                  </tr>
                  <tr className={metricReport.numberOfAttribute.score < 80 ? 'danger' : ''}>
                    <td>Number of attributes</td>
                    <td>{metricReport.numberOfAttribute.value}</td>
                    <td>{metricReport.numberOfAttribute.benchmark}</td>
                    <td>{metricReport.numberOfAttribute.score}%</td>
                  </tr>
                </tbody>
              </table>
            </div>;
  }
}

